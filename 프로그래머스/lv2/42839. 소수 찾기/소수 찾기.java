class Solution {
	private final int INF = 10000000;
	private int res;
	boolean[] isNotPrime;
    public int solution(String numbers) {
    	res = 0;
    	isNotPrime = new boolean[INF];
    	
    	isNotPrime[0] = isNotPrime[1] = true;
    	for(int i = 2; i < INF/2; i++) isNotPrime[i*2] = true;
    	for(int i = 3; i <= Math.sqrt(INF); i++) {
    		int num = 2;
    		while(i*num < INF) isNotPrime[i*num++] = true;
    	}
    	
    	String[] s = numbers.split("");
    	int[] nums = new int[s.length];
    	for(int i = 0; i < s.length; i++) nums[i] = Integer.parseInt(s[i]);
    	
    	boolean[] visit = new boolean[nums.length];
    	for(int i = 1; i <= nums.length; i++) {
    		find(i, 0, nums, 0, visit);
    	}
        return res;
    }
    private void find(int cnt, int cur, int[] nums, int depth, boolean[] visit) {
    	if (depth == cnt) {
    		if (!isNotPrime[cur]) {
    			isNotPrime[cur] = true;
    			res++;
    		}
    		return;
    	}
    	for(int i = 0; i < nums.length; i++) {
    		if (visit[i]) continue;
    		visit[i] = true;
    		find(cnt, cur*10+nums[i], nums, depth+1, visit);
    		visit[i] = false;
    	}
    }
}