package q43162;

/*

*/

class Solution {
	private int coms[][];
	private boolean visit[];
	
    public int solution(int n, int[][] computers) {
    	int res = 0;
        coms = computers;
        visit = new boolean[n];
        
        for(int i = 0; i < n; i++) if (find(i, n)) res++;
        return res;
    }
    private boolean find(int k, int n) {
    	if (visit[k]) return false;
    	visit[k] = true;
    	
    	for(int i = 0; i < n; i++) if (coms[k][i] == 1) find(i, n);
    	return true;
    }
}