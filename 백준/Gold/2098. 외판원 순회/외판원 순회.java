import java.io.*;
import java.util.*;
 
public class Main {
	static final int INF = 23456789;
	static int arr[][], dp[][], N;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][(1 << N) - 1];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.print(res(0, 1));
	}
	static int res(int cur, int v) {
		if (v == (1 << N) - 1) return arr[cur][0] == 0 ? INF : arr[cur][0];
		if (dp[cur][v] != 0) return dp[cur][v];
		
		int res = INF;
		for(int i = 0; i < N; i++) {
			if ((v & (1 << i)) != 0) continue;
			if (arr[cur][i] == 0) continue;
			
			res = Math.min(res, res(i, v | (1 << i)) + arr[cur][i]);
		}
		return dp[cur][v] = res;
	}
}