import java.io.*;
import java.util.*;

public class Main {
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]), pqs[] = new PriorityQueue[3];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, res = 0, cnt = 0, root[];
	public static void main(String[] args) throws IOException{
		root = new int[N = Integer.parseInt(br.readLine())];
		for(int i = 0; i < 3; i++) pqs[i] = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		for(int i = 0; i < N; root[i] = i++) for(int j = st(0); j < 3; j++) pqs[j].add(new int[] {i, in()});
		for(int i = 0; i < 3; i++) for(int j = 0; j < N-1; j++) {
			int[] cur = pqs[i].poll(), next = pqs[i].peek();
			pq.add(new int[] {cur[0], next[0], Math.abs(cur[1]-next[1])});
		}
		while(!pq.isEmpty()) {
			int edge[] = pq.poll(), s = root(edge[0]), e = root(edge[1]);
			if (s != e) {res += edge[2]; root[e] = s; if (++cnt == N-1) break;}
		}
		System.out.println(res);
	}
	static int st(int n) {try {st = new StringTokenizer(br.readLine());} catch (IOException e) {} return n;}
	static int in() {return Integer.parseInt(st.nextToken());}
	static int root(int n) {return root[n] == n ? n : (root[n] = root(root[n]));}
}