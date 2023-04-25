class Solution {
    public int solution(int k, int[][] dungeons) {
    	int N = dungeons.length, res = 0;
    	boolean[] visit = new boolean[N];
    	for(int i = 0; i < N; i++) {
    		visit[i] = true;
    		res = Math.max(res, root(i, k, dungeons, visit));
    		visit[i] = false;
    	}
        return res;
    }
    private int root(int c, int tired, int[][] d, boolean[] visit) {
    	if (tired < d[c][0]) return 0;
    	int cnt = 0;
    	for(int i = 0; i < d.length; i++) {
    		if (visit[i]) continue;
    		int cur = tired - d[c][1];
    		visit[i] = true;
    		cnt = Math.max(cnt, root(i, cur, d, visit));
    		visit[i] = false;
    	}
    	return cnt+1;
    }
}