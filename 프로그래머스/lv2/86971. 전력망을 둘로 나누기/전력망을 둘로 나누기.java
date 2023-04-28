class Solution {
    public int solution(int n, int[][] wires) {
    	int res = 101;
        for(int i = 0; i < wires.length; i++) {
        	boolean[] visit = new boolean[n-1];
        	int cnt = count(i == 1 ? 2 : 1, i, n, wires, visit);
        	res = Math.min(res, Math.abs(n - cnt*2));
        }
        return res;
    }
    private int count(int cur, int cut, int n, int[][] wires, boolean[] visit) {
    	int res = 1;
    	for(int i = 0; i < n-1; i++) {
    		if (i == cut || visit[i]) continue;
    		if (wires[i][0] != cur && wires[i][1] != cur) continue;
    		visit[i] = true;
    		int next = wires[i][0] == cur ? wires[i][1] : wires[i][0];
    		res += count(next, cut, n, wires, visit);
    	}
    	return res;
    }
}