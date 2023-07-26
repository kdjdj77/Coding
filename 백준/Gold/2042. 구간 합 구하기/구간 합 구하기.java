import java.io.*;
import java.util.*;

public class Main {
	static long[] num, tree;
	public static void main(String[] args) {
		Reader fr = new Reader();
		int N = fr.nextInt(), M = fr.nextInt(), K = fr.nextInt();
		num = new long[N+1];
		tree = new long[N<<2];
		for(int i = 1; i <= N; i++) num[i] = fr.nextLong();
		set(1, 1, N);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M + K; i++) {
			int a = fr.nextInt(), b = fr.nextInt();
			if (a == 1) {
				long c = fr.nextLong(), dif = c - num[b];
				num[b] = c;
				update(1, 1, N, b, dif);
			} else sb.append(res(1, 1, N, b, fr.nextInt())).append("\n");
		}
		System.out.print(sb);
	}
	public static long set(int node, int s, int e) {
		if (s == e) return tree[node] = num[s];
		int m = s+e >> 1;
		return tree[node] = set(node<<1, s, m) + set((node<<1)+1, m+1, e);
	}
	public static long res(int node, int s, int e, int l, int r) {
		if (r < s || e < l) return 0;
		if (l <= s && e <= r) return tree[node];
		int m = s+e >> 1;
		return res(node<<1, s, m, l, r) + res((node<<1)+1, m+1, e, l, r);
	}
	public static void update(int node, int s, int e, int idx, long dif) {
		if (idx < s || e < idx) return;
		tree[node] += dif;
		if (s == e) return;
		int m = s+e >> 1;
		update(node<<1, s, m, idx, dif);
		update((node<<1)+1, m+1, e, idx, dif);
	}
}
class Reader {
	BufferedReader br; StringTokenizer st;
    Reader(){br=new BufferedReader(new InputStreamReader(System.in));}
    String nextStr(){if(st==null||!st.hasMoreTokens())try{st=new StringTokenizer(br.readLine());}catch(IOException e){}return st.nextToken();}
    int nextInt(){return Integer.parseInt(nextStr());}
    long nextLong(){return Long.parseLong(nextStr());}
}