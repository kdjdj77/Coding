import java.io.*;

public class Main {
	static char[] str;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = (str = br.readLine().toCharArray()).length, dp[] = new int[len+1];
		boolean[][] isP = new boolean[len+1][len+1];
		for(int i = 1; i <= len; i++) dp[i] = 3456;
		for(int s = 1; s <= len; s++) for(int e = s; e <= len; e++) isP[s][e] = isP(s-1, e-1);
		for(int e = 1; e <= len; e++) for(int s = 1; s <= e; s++)
			if (isP[s][e]) dp[e] = Math.min(dp[s-1]+1, dp[e]);
		System.out.print(dp[len]);
	}
	static boolean isP(int s, int e) {
		while(s <= e) if (str[s++] != str[e--]) return false;
		return true;
	}
}