import java.io.*;
import java.util.*;

public class Main {
	static char[] S;
	static int len, dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(dp = new int[len = (S = br.readLine().toCharArray()).length + 1], len--);
        dp[2] = S[dp[0] = 0] == S[dp[1] = 1] ? 1 : 2;
        for(int i = 2; i < len; pal(i, i-1), pal(i-1, i-1), i++) dp[i+1] = Math.min(dp[i+1], dp[i]+1);
        System.out.print(dp[len]);
    }
    static void pal(int s, int e) {
        while(0 < s-- && ++e < len && S[s] == S[e]) dp[e+1] = Math.min(dp[e+1], dp[s]+1);
    }
}