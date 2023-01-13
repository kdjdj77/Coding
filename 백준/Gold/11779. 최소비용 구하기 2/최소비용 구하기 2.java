import java.io.*;
import java.util.*;
 
class Node implements Comparable<Node> {
    int next, w;
    Node(int next, int w) {
        this.next = next;
        this.w = w;
    }
    @Override
    public int compareTo(Node n) {
        return w - n.w;
    }
}
public class Main {
    static int N, E;
    static ArrayList<ArrayList<Node>> A;
    static int[] dp, path;
    static final int INF = 200000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
 
        A = new ArrayList<>();
        dp = new int[N+1];
        path = new int[N+1];

        for (int i = 0; i <= N; i++)  A.add(new ArrayList<>());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            A.get(x).add(new Node(y, w));
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        sb.append(dijkstra(s, e)).append("\n");
        
        int cnt = 1;
        Stack<Integer> stack = new Stack<>();
        stack.add(e);
        while(path[e] != 0) {
        	stack.add(path[e]);
        	e = path[e];
        	cnt++;
        }
        sb.append(cnt).append("\n");
        while(!stack.isEmpty()) sb.append(stack.pop()).append(" ");
        System.out.print(sb);
    }
    public static int dijkstra(int x, int y) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];
        Arrays.fill(dp, INF);
        q.add(new Node(x, 0));
        dp[x] = 0;
 
        while (!q.isEmpty()) {
            int cur = q.poll().next;
            if (cur == y) break;
            
            if (check[cur]) continue;
            check[cur] = true;
            for (Node n : A.get(cur)) {
                if (!check[n.next] && dp[n.next] > dp[cur] + n.w) {
                    dp[n.next] = dp[cur] + n.w;
                    q.add(new Node(n.next, dp[n.next]));
                    path[n.next] = cur;
                }
            }
        }
        return dp[y];
    }
}