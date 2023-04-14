import java.util.*;
class Solution {
    static int[][] dp;
    public int solution(int[][] tri) {
        int row = tri.length;
        dp = new int[row][row];
        dp[0][0] = tri[0][0];
        for(int i = 1; i < row; i++) {
            for(int j = 0; j <= i; j++) {
                if (j == 0) dp[i][j] = dp[i-1][j] + tri[i][j];
                else if (j == i) dp[i][j] = dp[i-1][j-1] + tri[i][j];
                else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + tri[i][j];
            }
        }
        int max = 0;
        for(int n : dp[row-1]) if (n > max) max = n;
        return max;
    }
}