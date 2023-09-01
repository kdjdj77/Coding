import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M], dp = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		dp[0][0] = map[0][0];
		for(int i = 1; i < M; i++) dp[0][i] = dp[0][i-1] + map[0][i];
		for(int i = 1, R[] = new int[M], L[] = new int[M]; i < N; i++) {
			R[0] = map[i][0] + dp[i-1][0];
			L[M-1] = map[i][M-1] + dp[i-1][M-1];
			for(int j = 1; j < M; j++) R[j] = map[i][j] + Math.max(R[j-1], dp[i-1][j]);
			for(int j = M-2; j >= 0; j--) L[j] = map[i][j] + Math.max(L[j+1], dp[i-1][j]);
			for(int j = 0; j < M; j++) dp[i][j] = Math.max(R[j], L[j]);
		}
		System.out.print(dp[N-1][M-1]);
	}	
}