import java.util.*;

class Pos {
	int x, y;
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
class Solution {
	static char[][] maze;
	static int N, M;
	static final int[][] move = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
	
    public int solution(String[] maps) {
    	N = maps.length;
    	M = maps[0].length();
    	
    	maze = new char[N][M];
    	Pos S, L, E;
    	S = E = L = null;
    	for(int i = 0; i < N; i++) {
    		String s = maps[i];
    		for(int j = 0; j < M; j++) {
    			char c = s.charAt(j);
    			maze[i][j] = c;
    			switch(c) {
    				case 'S' : S = new Pos(i, j); break;
    				case 'L' : L = new Pos(i, j); break;
    				case 'E' : E = new Pos(i, j); break;
    			}
    		}
    	}
    	int res1 = res(S, L);
    	int res2 = res(L, E);
    	return res1 == 0 || res2 == 0 ? -1 : res(S, L) + res(L, E);
    }
    private int res(Pos s, Pos e) {
    	int[][] dp = new int[N][M];
    	
    	Queue<Pos> q = new LinkedList<>();
    	q.add(s);
    	while(!q.isEmpty()) {
    		Pos cur = q.poll();
    		if (cur.x == e.x && cur.y == e.y) break;
    		for(int i = 0; i < 4; i++) {
    			int x = cur.x + move[i][0], y = cur.y + move[i][1];
    			if (x < 0 || x >= N || y < 0 || y >= M) continue;
    			if (maze[x][y] == 'X' || dp[x][y] != 0) continue;
    			q.add(new Pos(x, y));
    			dp[x][y] = dp[cur.x][cur.y] + 1; 
    		}
    	}
    	return dp[e.x][e.y];
    }
}