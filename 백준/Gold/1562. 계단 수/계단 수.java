import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine()), ok = (1<<10)-1, M = 1000000000;
		int dp[][][] = new int[10][N+1][ok+1], res = 0;

		for(int i = 1; i < 10; i++) dp[i][1][1<<i] = 1;
		for(int d = 2; d <= N; d++) for(int n = 0; n < 10; n++) for(int v = 0; v <= ok; v++) {
			int v2 = v | (1<<n);
			if (n != 0) dp[n][d][v2] += dp[n-1][d-1][v] % M;
			if (n != 9) dp[n][d][v2] += dp[n+1][d-1][v] % M;
			dp[n][d][v2] %= M;
		}
		for (int i = 0; i < 10; i++) res = (res + dp[i][N][ok]) % M;
		System.out.print(res);
	}
}