import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int road[];
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = in(), M = in(), tmp = 0, res = 0;
		road = new int[N+1];
		for(int i = 1; i <= N; i++) road[i] = i;
		
		PriorityQueue<int[]> path = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			path.add(new int[] {in(), in(), in()});
		}
		while(!path.isEmpty()) {
			int[] n = path.poll();
			if (!isSameRoot(n[0], n[1])) {union(n[0], n[1]); res += tmp = n[2];}
		}
		System.out.print(res - tmp);
	}
	static int in() {return Integer.parseInt(st.nextToken());}
	static boolean isSameRoot(int x, int y) {return root(x) == root(y);}
	static int root(int x) { return x == road[x] ? x : (road[x] = root(road[x])); }
    static void union(int x, int y) {
        x = root(x); y = root(y);
        if (x < y) road[y] = x;
        else road[x] = y;
    }
}