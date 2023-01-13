import java.io.*;
import java.util.*;

class Node {
	int next, w;
	public Node(int n, int w) {
		this.next = n;
		this.w = w;
	}
}
public class Main {
	static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
	static boolean[] visit;
	static int max = 0, edge;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		
		for(int i = 0; i <= N; i++) tree.add(new ArrayList<>());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			while(true) {
				int e = Integer.parseInt(st.nextToken());
				if (e == -1) break;
				int w = Integer.parseInt(st.nextToken());
				tree.get(s).add(new Node(e, w));
			}
		}
		dfs(1, 0);
		visit = new boolean[N+1];
		dfs(edge, 0);
		System.out.print(max);
	}
	public static void dfs(int x, int len) {
        if(len > max) { max = len; edge = x; }
        visit[x] = true;
        
        for(Node n : tree.get(x)) {
            if(!visit[n.next]) {
                dfs(n.next, n.w + len);
                visit[n.next] = true;
            }
        }
    }
}