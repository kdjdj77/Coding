class Solution {
    public int solution(int[] money) {
        return Math.max(calc(true, money), calc(false, money));
    }
    private int calc(boolean start0, int[] money) {
    	int N = money.length, dp[] = new int[N];
    	dp[1] = start0 ? dp[0] = money[0] : money[1];
    	
    	for (int i = 2; i < N; i++) dp[i] = Math.max(dp[i-1], money[i] + dp[i-2]);
    	
    	return start0 ? dp[N-2] : dp[N-1];
    }
}