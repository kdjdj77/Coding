package q28_최단경로.a07_1956;
/*
3 4
1 2 1
3 2 1
1 3 5
2 3 2
*/

import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) Arrays.fill(dp[i], INF);
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (dp[a][b] > c) dp[a][b] = c;
		}
		for(int m = 1; m <= N; m++)
			for(int s = 1; s <= N; s++)
				for(int e = 1; e <= N; e++)
					if (dp[s][e] > dp[s][m] + dp[m][e]) 
						dp[s][e] = dp[s][m] + dp[m][e];
		int res = INF;
		for(int i = 1; i <= N; i++) if (dp[i][i] < res) res = dp[i][i];
		System.out.print(res == INF ? -1 : res);
	}
}