class Solution {
	private static int coms[][];
	private static boolean visit[];
    public int solution(int n, int[][] computers) {
        coms = computers;
        visit = new boolean[n];
        int res = 0;
        
        for(int i = 0; i < n; i++) if (find(i)) res++;
        return res;
    }
    private boolean find(int n) {
    	if (visit[n] == true) return false;
    	visit[n] = true;
    	
    	for(int i = 0; i < visit.length; i++) if (coms[n][i] == 1) find(i);
    	return true;
    }
}