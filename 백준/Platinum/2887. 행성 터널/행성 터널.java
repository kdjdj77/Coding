import java.io.*;
import java.util.*;

public class Main {
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int p, root[];
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine()), S[][] = new int[N][4], res = 0;
		root = new int[N];
		for(int i = 0; i < N; i++) S[i] = new int[] {root[i] = st(i), in(), in(), in()};
		for(p = 1; p < 4; p++) {
			Arrays.sort(S, (p1, p2) -> p1[p] - p2[p]);
			for(int i = 1; i < N; i++) pq.add(new int[] {S[i-1][0], S[i][0], Math.abs(S[i-1][p]-S[i][p])});
		}
		while(!pq.isEmpty()) {
			int cur[] = pq.poll(), s = find(cur[0]), e = find(cur[1]);
			if (s != e) {res += cur[2]; root[e] = s;}
		}
		System.out.print(res);
	}
	static int st(int n) {try {st = new StringTokenizer(br.readLine());} catch (IOException e) {} return n;}
	static int find(int x) {return root[x] == x ? x : (root[x] = find(root[x]));}
	static int in() {return Integer.parseInt(st.nextToken());}
}