import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), C[][] = new int[53][53], MOD = 10007, res = 0;
		for(int n = 0; n < 53; n++)
	        for(int r = C[n][n] = C[n][0] = 1; r <= n/2; r++)
	        	C[n][n-r] = C[n][r] = (C[n-1][r-1]+C[n-1][r]) % MOD;
	    for(int i = 1, k; (k = i<<2) <= N; res %= MOD, i++)
	    	res += ((i%2<<1)-1) * C[13][i] * C[52-k][N-k];
	    System.out.print(res < 0 ? res + MOD : res);
	}
}