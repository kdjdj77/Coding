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
		int[][] path = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= N; j++)
				if (i != j) dp[i][j] = INF;
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (dp[a][b] > c) dp[a][b] = c;
			path[a][b] = a;
		}
		for(int m = 1; m <= N; m++)
			for(int s = 1; s <= N; s++)
				for(int e = 1; e <= N; e++)
					if (dp[s][e] > dp[s][m] + dp[m][e]) { 
						dp[s][e] = dp[s][m] + dp[m][e];
						path[s][e] = path[m][e];
					}
					
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) 
				sb.append(dp[i][j] == INF ? 0 : dp[i][j]).append(" ");
			sb.append("\n");
		}
		
		for(int s = 1; s <= N; s++) {
			for (int e = 1; e <= N; e++) {
				int p = path[s][e];
				if (s == e || p == 0) { sb.append(0).append("\n"); continue; }

				Stack<Integer> S = new Stack<>();
				while (p != 0) { S.push(p); p = path[s][p]; }
				
				sb.append(S.size() + 1).append(" ");
				while (!S.empty()) sb.append(S.pop()).append(" ");
				sb.append(e).append("\n");
			}
		}
		System.out.print(sb);
	}
}