import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int x, y, init[];
	static ArrayList<int[]> bundle;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		st(); int N = in(), M = in(), K = in();
		init = new int[N+1];
		list = new ArrayList[N+1]; st();
		for(int i = 1; i <= N; i++) init[i] = in();
		for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
		while(M-- > 0) {st();
			int a = in(), b = in();
			list[a].add(b);
			list[b].add(a);
		}
		bundle = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			if (init[i] == 0) continue;
			x = 0; y = 0; dfs(i);
			bundle.add(new int[] {x, y});
		}
		int[][] dp = new int[2][K];
		for(int[] b : bundle) {
			for(int i = 0; i < K; i++) dp[1][i] = b[0] <= i ? Math.max(dp[0][i], dp[0][i-b[0]]+b[1]) : dp[0][i];
			for(int i = 0; i < K; i++) dp[0][i] = dp[1][i];
		}
		System.out.print(dp[1][K-1]);
	}
	static void dfs(int n) {
		y += init[n]; x++;
		init[n] = 0;
		for(int next : list[n]) if (init[next] != 0) dfs(next);
	}
	static void st() {try {st = new StringTokenizer(br.readLine());} catch (IOException e) {}}
	static int in() {return Integer.parseInt(st.nextToken());}
}