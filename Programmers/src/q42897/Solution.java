package q42897;

/*

*/

class Solution {
    public int solution(int[] money) {
        return Math.max(calc(true, money), calc(false, money));
    }
    private int calc(boolean get0, int[] m) {
    	int N = m.length, dp[] = new int[N];
    	dp[1] = get0 ? dp[0] = m[0] : m[1];
    	
    	for (int i = 2; i < N; i++) dp[i] = Math.max(dp[i-1], m[i] + dp[i-2]);
    	
    	return get0 ? dp[N-2] : dp[N-1];
    }
}