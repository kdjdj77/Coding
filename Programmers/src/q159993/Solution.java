package q159993;

/*
문제 설명
1 x 1 크기의 칸들로 이루어진 직사각형 격자 형태의 미로에서 탈출하려고 합니다. 각 칸은 통로 또는 벽으로 구성되어 있으며, 벽으로 된 칸은 지나갈 수 없고 통로로 된 칸으로만 이동할 수 있습니다. 통로들 중 한 칸에는 미로를 빠져나가는 문이 있는데, 이 문은 레버를 당겨서만 열 수 있습니다. 레버 또한 통로들 중 한 칸에 있습니다. 따라서, 출발 지점에서 먼저 레버가 있는 칸으로 이동하여 레버를 당긴 후 미로를 빠져나가는 문이 있는 칸으로 이동하면 됩니다. 이때 아직 레버를 당기지 않았더라도 출구가 있는 칸을 지나갈 수 있습니다. 미로에서 한 칸을 이동하는데 1초가 걸린다고 할 때, 최대한 빠르게 미로를 빠져나가는데 걸리는 시간을 구하려 합니다.

미로를 나타낸 문자열 배열 maps가 매개변수로 주어질 때, 미로를 탈출하는데 필요한 최소 시간을 return 하는 solution 함수를 완성해주세요. 만약, 탈출할 수 없다면 -1을 return 해주세요.
*/

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