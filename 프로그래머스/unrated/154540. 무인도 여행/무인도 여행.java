import java.util.*;

class Solution {
	static int N, M, map[][];
	static boolean visit[][];
	
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        
    	map = new int[N][M];
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++)
    			if (maps[i].charAt(j) == 'X') map[i][j] = 0;
    			else map[i][j] = maps[i].charAt(j) - '0';
    	

    	visit = new boolean[N][M];
    	ArrayList<Integer> dp = new ArrayList<>();
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			if (visit[i][j] || map[i][j] == 0) continue;
    			
    			dp.add(search(i, j));
    		}
    	}
    	int[] res = new int[dp.size()];
    	for(int i = 0; i < dp.size(); i++) res[i] = dp.get(i);
    	Arrays.sort(res);
    	
    	return res.length == 0 ? new int[] {-1} : res;
    }
    private int search(int i, int j) {
    	if (i < 0 || i >= N || j < 0 || j >= M) return 0;
    	if (map[i][j] == 0 || visit[i][j]) return 0;
    	
    	visit[i][j] = true;
    	int res = map[i][j];
    	for(int[] next : new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
    		int x = i + next[0], y = j + next[1];
    		res += search(x, y);
    	}
    	return res;
    }
}