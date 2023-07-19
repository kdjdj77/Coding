import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st = new StringTokenizer("");
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, tree[];
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int T = in();
		while(T-- > 0) {
			N = in(); M = in();
			int[] idx = new int[N + 1];
			for(int i = 1; i <= N; i++) idx[i] = M+i-1;

			tree = new int[N+M << 2];
			set(1, 0, N+M-1);
			for(int i = 0; i < M; i++) {
				int mov = in(), cur = idx[mov];
				sb.append(res(1, 0, N+M-1, 0, cur-1)).append(" ");
				update(1, 0, N+M-1, cur, -1);
				update(1, 0, N+M-1, M-i-1, 1);
				idx[mov] = M-i-1;
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	static int in() throws IOException {
		if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	static int set(int node, int s, int e) {
		if (s == e) return tree[node] = (s < M ? 0 : 1);
		int m = s+e >> 1, next = node << 1;
		tree[node] = set(next, s, m) + set(next+1, m+1, e);
		return tree[node];
	}
	static int res(int node, int s, int e, int l, int r) {
		if (r < s || e < l) return 0;
		if (l <= s && e <= r) return tree[node];
		int m = s+e >> 1, next = node << 1;
		return res(next, s, m, l, r) + res(next+1, m+1, e, l, r);
	}
	static void update(int node, int s, int e, int idx, int dif) {
		if (idx < s || e < idx) return;
		tree[node] += dif;
		if (s < e) {
			int m = s+e >> 1, next = node << 1;
			update(next, s, m, idx, dif);
			update(next+1, m+1, e, idx, dif);
		}
	}
}