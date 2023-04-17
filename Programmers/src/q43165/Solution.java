package q43165;

/*

*/


class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(0, numbers, 0, target);
    }
    private int dfs(int num, int[] nums, int depth, int t) {
    	if (depth == nums.length) return num == t ? 1 : 0;
    	int res = dfs(num + nums[depth], nums, depth + 1, t);
    	return res + dfs(num - nums[depth], nums, depth + 1, t);
    }
}