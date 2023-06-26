import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int road[];
	public static void main(String[] args) throws IOException {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		st = new StringTokenizer(br.readLine());
		int N = in(), M = in(), tmp = 0, res = 0; road = new int[N+1];
		while(tmp++ < N) road[tmp] = tmp;
		while(M-- > 0) {st = new StringTokenizer(br.readLine()); pq.add(new int[] {in(), in(), in()});}
		while(!pq.isEmpty()) {
			int n[] = pq.poll(), r1 = root(n[0]), r2 = root(n[1]);
			if (r1 != r2) {union(r1, r2); res += tmp = n[2];}
		}
		System.out.print(res - tmp);
	}
	static int in() {return Integer.parseInt(st.nextToken());}
	static int root(int x) {return road[x] != x ? road[x] = root(road[x]) : x;}
    static void union(int x, int y) {if (x < y) road[y] = x; else road[x] = y;}
}