package q28_최단경로.a06_11404;
/*
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4
*/

import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) 
			for(int j = 1; j <= N; j++) 
				dp[i][j] = i == j ? 0 : INF;
		
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
					
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) 
				sb.append(dp[i][j] == INF ? 0 : dp[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.print(sb);
	}
}