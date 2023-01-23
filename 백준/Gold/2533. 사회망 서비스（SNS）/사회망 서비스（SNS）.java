import java.io.*;
import java.util.*;
 
public class Main {
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static int N, dp[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][2];
		
		for(int i = 0; i <= N; i++) tree.add(new ArrayList<>());
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree.get(u).add(v); tree.get(v).add(u);
		} tree.get(0).add(1);
		
		dfs(-1, 0);
		System.out.print(dp[0][1]-1);
	}
	static void dfs(int root, int cur) {
		dp[cur][0] = 0;
		dp[cur][1] = 1;
		for(int next : tree.get(cur)) {
			if (root == next) continue;
			dfs(cur, next);
			dp[cur][0] += dp[next][1];
			dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
		}
	}
}