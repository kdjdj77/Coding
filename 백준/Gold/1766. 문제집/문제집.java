import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
 
        int[] indegree = new int[N+1];
        ArrayList<ArrayList<Integer>> link = new ArrayList<>();
 
        for (int i = 0; i <= N; i++) link.add(new ArrayList<>());
 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
 
            link.get(s).add(e);
            indegree[e]++;
        }
 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) if (indegree[i] == 0) pq.add(i);

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(" ");

            for (int next : link.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) pq.offer(next);
            }
        }
        System.out.print(sb);
    }
}