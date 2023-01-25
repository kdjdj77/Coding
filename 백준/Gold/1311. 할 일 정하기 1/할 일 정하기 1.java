import java.io.*;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int N, dp[][], graph[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		dp = new int[N][1 << N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) graph[i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.print(res(0, 0));
	}
	static int res(int w, int e) {
		if (w == N) return 0;
		if (dp[w][e] != 0) return dp[w][e];

		int res = INF;
		for (int i = 0; i < N; i++)
			if ((e & (1<<i)) == 0) 
				res = Math.min(res, graph[w][i] + res(w+1, e | (1<<i)));
		
		return dp[w][e] = res;
	}
}