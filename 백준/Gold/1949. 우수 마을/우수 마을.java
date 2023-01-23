import java.io.*;
import java.util.*;
 
public class Main {
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static int[] town, dp[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		town = new int[N+1];
		dp = new int[N+1][2];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) town[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= N; i++) tree.add(new ArrayList<>());
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			tree.get(x).add(y); tree.get(y).add(x);
		}
		dfs(0, 1);
		System.out.print(Math.max(dp[1][0], dp[1][1]));
	}
	static void dfs(int root, int cur) {
		dp[cur][0] = 0;
		dp[cur][1] = town[cur];
		for(int next : tree.get(cur)) {
			if (root == next) continue;
			dfs(cur, next);
			dp[cur][1] += dp[next][0];
			dp[cur][0] += Math.max(dp[next][0], dp[next][1]);
		}
	}
}