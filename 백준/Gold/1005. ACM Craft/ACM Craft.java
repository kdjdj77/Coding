import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] link = new ArrayList[N + 1];
            int[] cost = new int[++N], need = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i < N; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
                link[i] = new ArrayList<>();
            }
            while(K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
                link[a].add(b); need[b]++;
            }
            int W = Integer.parseInt(br.readLine()), dp[] = new int[N];
            Queue<Integer> q = new LinkedList<>();
            for(int i = 1; i < N; i++) if (need[i] == 0) q.add(i);
            while(!q.isEmpty()) {
                int cur = q.poll();
                dp[cur] += cost[cur];
                for (int n : link[cur]) {
                    dp[n] = Math.max(dp[n], dp[cur]);
                    if (--need[n] == 0) q.add(n);
                }
            }
            sb.append(dp[W]).append("\n");
        }
        System.out.print(sb);
    }
}