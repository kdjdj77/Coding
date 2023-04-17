class Solution {
	static int res, t, nums[];
    public int solution(int[] numbers, int target) {
    	res = 0;
    	t = target;
    	nums = numbers;        
        dfs(0, 0);
        return res;
    }
    private void dfs(int num, int depth) {
    	if (depth == nums.length) {
    		if (num == t) res++;
    		return;
    	}
    	dfs(num + nums[depth], depth + 1);
    	dfs(num - nums[depth], depth + 1);
    }
}