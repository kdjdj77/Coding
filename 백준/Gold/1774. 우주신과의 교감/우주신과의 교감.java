import java.io.*;
import java.util.*;

class God {
	int x, y;
	public God(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
class Node implements Comparable<Node> {
	int l, r;
	Double w;
	public Node(int l, int r, Double w) {
		this.l = l;
		this.r = r;
		this.w = w;
	}
	@Override
	public int compareTo(Node o) {
		return this.w > o.w ? 1 : -1;
	}
}
public class Main {
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		A = new int[N+1];
		for(int i = 1; i <= N; i++) A[i] = i;
		
		God[] gods = new God[N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			gods[i] = new God(x, y);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		PriorityQueue<Node> path = new PriorityQueue<>();
		for(int i = 1; i < N; i++) {
			for(int j = i+1; j <= N; j++) {
				long dx = gods[i].x - gods[j].x;
				long dy = gods[i].y - gods[j].y;
				Double dist = Math.sqrt(dx*dx + dy*dy);
				if (!isSameRoot(i, j)) path.add(new Node(i, j, dist));
			}
		}
		
		Double res = 0d;
		while(!path.isEmpty()) {
			Node n = path.poll();
			if (!isSameRoot(n.l, n.r)) {
				union(n.l, n.r);
				res += n.w;
			}
		}
		System.out.print(String.format("%.2f", res));
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