import java.io.*;
import java.util.*;

public class Main {
	static char[] str;
	static int len, dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(dp = new int[len = (str = br.readLine().toCharArray()).length], len);
        dp[dp[0] = 1] = str[0] == str[1] ? 1 : 2;
        for(int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i-1]+1, dp[i]);
            for(int j = 0; j < 2; j++) if (str[i] == str[i-1-j]) pal(i-j, i-1);
        }
        System.out.print(dp[len-1]);
    }
    static void pal(int s, int e) {
        while(0 < s && e < len-1 && str[--s] == str[++e])
            dp[e] = s == 0 ? 1 : Math.min(dp[e], dp[s-1]+1);
    }
}