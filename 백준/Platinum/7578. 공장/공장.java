import java.io.*;
import java.util.*;

public class Main {
	static long[] tree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), A[] = new int[N+1];
		Map<Integer, Integer> B = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) B.put(Integer.parseInt(st.nextToken()), i);

		tree = new long[N<<2];
		long res = 0;
		for(int i = 1; i <= N; i++) {
			int v = B.get(A[i]);
			res += calc(1, N, 1, v+1, N);
			update(1, N, 1, v, 1);
		}
		System.out.print(res);
	}
	static long calc(int s, int e, int n, int l, int r) {
		if (e < l || r < s) return 0;
		if (l <= s && e <= r) return tree[n];
		int m = s+e >> 1;
		return calc(s, m, n<<1, l, r) + calc(m+1, e, (n<<1)+1, l, r);
	}
	static void update(int s, int e, int n, int idx, int dif) {
		if (idx < s || idx > e) return;
		tree[n] += dif;
		if (e <= s) return;
		int m = s+e >> 1;
		update(s, m, n<<1, idx, dif);
		update(m+1, e, (n<<1)+1, idx, dif);
	}
}