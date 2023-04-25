package q42839;

/*

*/

class Solution {
	private int res;
	private boolean[] isNotPrime;
	
    public int solution(String numbers) {
    	res = 0;
    	
    	int[] nums = parse(numbers);
    	
    	isNotPrime = setPrime(nums.length);
    	
    	boolean[] visit = new boolean[nums.length];
    	for(int i = 1; i <= nums.length; i++) find(i, 0, 0, nums, visit);
        return res;
    }
    private boolean[] setPrime(int len) {
    	int INF = (int)Math.pow(10, len);
    	boolean[] tmp = new boolean[INF];
    	tmp[0] = tmp[1] = true;
    	for(int i = 2; i < INF/2; i++) tmp[i*2] = true;
    	for(int i = 3; i <= Math.sqrt(INF); i++) {
    		int num = 2;
    		while(i*num < INF) tmp[i*num++] = true;
    	}
    	return tmp;
    }
    private int[] parse(String numbers) {
    	String[] s = numbers.split("");
    	int[] nums = new int[s.length];
    	for(int i = 0; i < s.length; i++) nums[i] = Integer.parseInt(s[i]);
    	return nums;
    }
    private void find(int cnt, int cur, int depth, int[] nums, boolean[] visit) {
    	if (depth == cnt) {
    		if (isNotPrime[cur]) return;
			isNotPrime[cur] = true;
			res++;
    		return;
    	}
    	for(int i = 0; i < nums.length; i++) {
    		if (visit[i]) continue;
    		visit[i] = true;
    		find(cnt, cur*10+nums[i], depth+1, nums, visit);
    		visit[i] = false;
    	}
    }
}