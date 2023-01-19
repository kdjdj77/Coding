import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int l, r, w;
	public Node(int l, int r, int w) {
		this.l = l;
		this.r = r;
		this.w = w;
	}
	@Override
	public int compareTo(Node o) {
		return this.w - o.w;
	}
}
public class Main {
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		A = new int[V+1];
		for(int i = 1; i <= V; i++) A[i] = i;
		
		ArrayList<Node> path = new ArrayList<>();
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			path.add(new Node(a, b, c));
		}
		Collections.sort(path);
		
		int res = 0;
		for(Node n : path) if (!isSameRoot(n.l, n.r)) { union(n.l, n.r); res += n.w; }
		
		System.out.print(res);
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