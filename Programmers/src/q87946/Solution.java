package q87946;

/*

*/

class Solution {
    public int solution(int k, int[][] dungeons) {
    	int N = dungeons.length;
    	boolean[] visit = new boolean[N];
		return root(k, dungeons, visit) - 1;
    }
    private int root(int tired, int[][] d, boolean[] visit) {
    	int cnt = 0;
    	for(int i = 0; i < d.length; i++) {
    		if (visit[i] || tired < d[i][0]) continue;
    		
    		visit[i] = true;
    		cnt = Math.max(cnt, root(tired - d[i][1], d, visit));
    		visit[i] = false;
    	}
    	return cnt+1;
    }
}