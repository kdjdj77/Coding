import java.io.*;
import java.util.*;

class Star {
	Double x, y;
	public Star(Double x, Double y) {
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
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		Star[] stars = new Star[N];
		PriorityQueue<Node> path = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Double x = Double.parseDouble(st.nextToken());
			Double y = Double.parseDouble(st.nextToken());
			stars[i] = new Star(x, y);
		}
		
		A = new int[N];
		for(int i = 1; i < N; i++) A[i] = i;
		
		for(int i = 0; i < N-1; i++)
			for(int j = i+1; j < N; j++) 
				path.add(new Node(i, j, dist(stars[i], stars[j])));
		
		float res = 0f;
		while(!path.isEmpty()) {
			Node n = path.poll();
			if (!isSameRoot(n.l, n.r)) {
				union(n.l, n.r);
				res += n.w;
			}
		}
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
    public static Double dist(Star a, Star b) {
    	Double dx = a.x - b.x;
    	Double dy = a.y - b.y;
    	return Math.sqrt(dx*dx + dy*dy);
    }
}