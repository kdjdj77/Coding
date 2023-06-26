import java.io.*;
import java.util.*;

public class Main {
    static long[] dp = new long[55];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken()), B = Long.parseLong(st.nextToken());
        dp[0] = 1;
        for(int i = 1; i < 55; i++) dp[i] = (dp[i-1]<<1) + (1L<<i);
        System.out.print(calc(B) - calc(A-1));
    }
    static long calc(long X) {
        long res = X & 1;
        for(int i = (int)(Math.log(X)/Math.log(2)); i > 0; i--)
        	if((X & (1L<<i)) != 0) res += dp[i-1] + (X -= (1L<<i)) + 1;
        return res;
    }
}