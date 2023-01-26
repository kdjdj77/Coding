import java.io.*;
import java.math.*;
import java.util.*;
 
public class Main {
	static BigInteger[] arr;
	static int N, K, maxBit, mods[][];
	static long[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new BigInteger[N];
		maxBit = (1 << N) - 1;
		for(int i = 0; i < N; i++) arr[i] = new BigInteger(br.readLine());
		
		K = Integer.parseInt(br.readLine());
		dp = new long[K][maxBit+1];
		mods = new int[K][N];
		
		for(int i = 0; i < K; i++) {
			Arrays.fill(mods[i], -1);
			Arrays.fill(dp[i], -1);
		}
		
		long res = dp(0, 0);
		if(res == 0) sb.append("0/1");
		else {
			long fac = fac(N);
			long gcd = gcd(fac, res);
			sb.append(res/gcd).append("/").append(fac/gcd);
		}
		System.out.print(sb);
	}
	static long dp(int mod, int visit) {
		if(dp[mod][visit] != -1) return dp[mod][visit];
		if(visit == maxBit) return mod == 0 ? 1 : 0;
		
		long res = 0;
		for(int i = 0; i < N; i++) {
			int cur = 1 << i;
			if((visit & cur) == 0) res += dp(mod(mod, i), visit|cur);
		}
		return dp[mod][visit] = res;
	}
	static int mod(int mod, int idx) {
		if(mods[mod][idx] != -1) return mods[mod][idx];
		BigInteger BI = new BigInteger(String.valueOf(mod) + String.valueOf(arr[idx]));
		return mods[mod][idx] = BI.remainder(BigInteger.valueOf(K)).intValue();
	}
	static long gcd(long n, long m) {
		if (m == 0) return n;
		return gcd(m, n % m);
	}
	static long fac(int n) {
		long res = 1;
		for(int i = 2; i <= N; i++) res *= i;
		return res;
	}
}