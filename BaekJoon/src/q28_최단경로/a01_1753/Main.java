package q28_최단경로.a01_1753;
/*
문제
방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 단, 모든 간선의 가중치는 10 이하의 자연수이다.

입력
첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다. 둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다. 셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다. 이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다. 서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.

출력
첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다. 시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int y, w;
    public Node(int y, int w) {
    	this.y = y; this.w = w; 
	}
    @Override
    public int compareTo(Node n) {
    	return w - n.w;
    }
}

public class Main {
    static int V, E, K, INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();;
    static int[] dp;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        dp = new int[V+1];

        Arrays.fill(dp, INF);

        for(int i = 0; i <= V; i++) list.add(new ArrayList<>());
        for(int i = 0 ; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(x).add(new Node(y, w));
        }
        dijkstra(K);
        for(int i = 1; i <= V; i++) 
        	sb.append(dp[i] == INF ? "INF" : dp[i]).append("\n");

        System.out.print(sb);
    }

    private static void dijkstra(int s){
       PriorityQueue<Node> q = new PriorityQueue<>();
       boolean[] visit = new boolean[V + 1];
       q.add(new Node(s, 0));
       dp[s] = 0;

       while(!q.isEmpty()){
           Node curNode = q.poll();
           int cur = curNode.y;
           if(visit[cur]) continue;
           
           visit[cur] = true;
           for(Node n : list.get(cur)){
               if(dp[n.y] > dp[cur] + n.w) {
                   dp[n.y] = dp[cur] + n.w;
                   q.add(new Node(n.y, dp[n.y]));
               }
           }
       }
    }
}