package q30_동적계획법과최단거리역추적.a08_11779;
/*
문제
n(1≤n≤1,000)개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1≤m≤100,000)개의 버스가 있다. 
우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다. 
그러면 A번째 도시에서 B번째 도시 까지 가는데 드는 최소비용과 경로를 출력하여라. 
항상 시작점에서 도착점으로의 경로가 존재한다.

입력
첫째 줄에 도시의 개수 n(1≤n≤1,000)이 주어지고 둘째 줄에는 버스의 개수 m(1≤m≤100,000)이 주어진다. 
그리고 셋째 줄부터 m+2줄까지 다음과 같은 버스의 정보가 주어진다. 
먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다. 
그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다. 
버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.

그리고 m+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다.

출력
첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.

둘째 줄에는 그러한 최소 비용을 갖는 경로에 포함되어있는 도시의 개수를 출력한다. 출발 도시와 도착 도시도 포함한다.

셋째 줄에는 최소 비용을 갖는 경로를 방문하는 도시 순서대로 출력한다.
*/

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
        Stack<Integer> S = new Stack<>();
        S.add(e);
        while(path[e] != 0) {
        	S.add(e = path[e]);
        	cnt++;
        }
        sb.append(cnt).append("\n");
        while(!S.isEmpty()) sb.append(S.pop()).append(" ");
        System.out.print(sb);
    }
    public static int dijkstra(int x, int y) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] check = new boolean[N+1];
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
                    q.add(new Node(n.next, dp[n.next] = dp[cur] + n.w));
                    path[n.next] = cur;
                }
            }
        }
        return dp[y];
    }
}