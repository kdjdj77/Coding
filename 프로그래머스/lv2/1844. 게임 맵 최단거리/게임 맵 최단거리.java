import java.util.*;

class Solution {
	private int N, M;
	private int[][] map, dp, move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
    public int solution(int[][] maps) {
    	N = maps.length;
    	M = maps[0].length;
    	map = maps;
    	dp = new int[N][M];
    	dp[0][0] = 1;
    	
    	bfs(0, 0);
        return dp[N-1][M-1] == 0 ? -1 : dp[N-1][M-1];
    }
    private void bfs(int i, int j) {
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {i, j});
    	
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		int cnt = dp[cur[0]][cur[1]];
	    	for(int[] m : move) {
	    		int x = cur[0] + m[0];
	    		int y = cur[1] + m[1];
	    		
	    		if (x >= N || y >= M || x < 0 || y < 0) continue;
	    		if (map[x][y] == 0 || dp[x][y] != 0) continue;
	    		
	    		dp[x][y] = cnt + 1;
	    		q.add(new int[] {x, y});
	    	}
    	}
    }
}