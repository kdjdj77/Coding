import java.util.*;
import java.io.*;

public class Main {
	static int[] w, dp[];
	static boolean[] select;
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		w = new int[N+1];
		dp = new int[N+1][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) w[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) tree.add(new ArrayList<>());
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		tree.get(0).add(1);

		select = new boolean[N+1];
		sb.append(setDP(0, 0, false)).append("\n");
		
		trace(0, 1, select[1]);
		for(int i = 1; i <= N; i++) if (select[i]) sb.append(i).append(" ");
		System.out.print(sb);
	}
	static int setDP(int root, int cur, boolean isOn) {
		int weight = isOn ? w[cur] : 0;
		for (int next : tree.get(cur)) {
			if(root != next) {
				int off = dp[next][0] = setDP(cur, next, false);
				if (!isOn) {
					int on = dp[next][1] = setDP(cur, next, true);
					select[next] = on > off;
					weight += Math.max(on, off);
				} else weight += off;
			}
		}
		return weight;
	}
	static void trace(int root, int cur, boolean b) {
		select[cur] = b;
		for(int next : tree.get(cur))
			if (root != next)
				trace(cur, next, b ? false : dp[next][1] > dp[next][0]);
	}
}