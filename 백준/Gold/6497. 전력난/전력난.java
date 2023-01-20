import java.io.*;
import java.util.*;

class Road implements Comparable<Road> {
	int l, r, w;
	public Road(int l, int r, int w) {
		this.l = l;
		this.r = r;
		this.w = w;
	}
	@Override
	public int compareTo(Road r) {
		return this.w - r.w;
	}
}
public class Main {
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			if (M == 0 && N == 0) break;
			
			A = new int[M];
			for(int i = 0; i < M; i++) A[i] = i;
			
			int res = 0;
			Road[] roads = new Road[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				roads[i] = new Road(x, y, z);
				res += z;
			}
			Arrays.sort(roads);
			
			for(Road r : roads) {
				if (!isSameRoot(r.l, r.r)) {
					union(r.l, r.r);
					res -= r.w;
				}
			}
			sb.append(res).append("\n");
		}
		System.out.print(sb);
	}
	public static int root(int x) {
        if(x == A[x]) return x;
        return A[x] = root(A[x]);
	}
    public static void union(int x, int y) {
        x = root(x); y = root(y);
        if (x == y) return;
        if (x < y) A[y] = x;
        else A[x] = y;
    }
    public static boolean isSameRoot(int x, int y) {
        return root(x) == root(y);
    }
}