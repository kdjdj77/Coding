package q28_최단경로.a02_1504;
/*
문제
방향성이 없는 그래프가 주어진다. 세준이는 1번 정점에서 N번 정점으로 최단 거리로 이동하려고 한다. 또한 세준이는 두 가지 조건을 만족하면서 이동하는 특정한 최단 경로를 구하고 싶은데, 그것은 바로 임의로 주어진 두 정점은 반드시 통과해야 한다는 것이다.

세준이는 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다. 하지만 반드시 최단 경로로 이동해야 한다는 사실에 주의하라. 1번 정점에서 N번 정점으로 이동할 때, 주어진 두 정점을 반드시 거치면서 최단 경로로 이동하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N과 간선의 개수 E가 주어진다. (2 ≤ N ≤ 800, 0 ≤ E ≤ 200,000) 둘째 줄부터 E개의 줄에 걸쳐서 세 개의 정수 a, b, c가 주어지는데, a번 정점에서 b번 정점까지 양방향 길이 존재하며, 그 거리가 c라는 뜻이다. (1 ≤ c ≤ 1,000) 다음 줄에는 반드시 거쳐야 하는 두 개의 서로 다른 정점 번호 v1과 v2가 주어진다. (v1 ≠ v2, v1 ≠ N, v2 ≠ 1) 임의의 두 정점 u와 v사이에는 간선이 최대 1개 존재한다.

출력
첫째 줄에 두 개의 정점을 지나는 최단 경로의 길이를 출력한다. 그러한 경로가 없을 때에는 -1을 출력한다.
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
    static int[] dp;
    static boolean[] visit;
    static final int INF = 200000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
 
        A = new ArrayList<>();
        dp = new int[N+1];
        visit = new boolean[N+1];

        for (int i = 0; i <= N; i++)  A.add(new ArrayList<>());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            A.get(x).add(new Node(y, w));
            A.get(y).add(new Node(x, w));
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int res1, res2;
        dijkstra(1); res1 = dp[a]; res2 = dp[b];
        dijkstra(a); res1 += dp[b]; res2 += dp[b];
        dijkstra(N); res1 += dp[b]; res2 += dp[a];

        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
        System.out.print(ans);
    }
    public static void dijkstra(int x) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];
        Arrays.fill(visit, false);
        Arrays.fill(dp, INF);
        q.offer(new Node(x, 0));
        dp[x] = 0;
 
        while (!q.isEmpty()) {
            Node node = q.poll();
            int cur = node.next;
            
            if (check[cur]) continue;
            check[cur] = true;
            for (Node n : A.get(cur)) {
                if (!check[n.next] && dp[n.next] > dp[cur] + n.w) {
                    dp[n.next] = dp[cur] + n.w;
                    q.add(new Node(n.next, dp[n.next]));
                }
            }
        }
    }
}