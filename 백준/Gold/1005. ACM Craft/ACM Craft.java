import java.io.*;
import java.util.*;

public class Main {
	private static int[] cost, depth;
	private static List<Set<Integer>> link;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
            link = new ArrayList<>();
            cost = new int[N+1];
            depth = new int[N+1];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i <= N; i++) link.add(new HashSet<>());
            for(int i = 1; i <= N; i++) cost[i] = Integer.parseInt(st.nextToken());
            while(K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
                link.get(a).add(b);
                depth[b]++;
            }
            sb.append(calc(N, Integer.parseInt(br.readLine()))).append("\n");    
        }
        System.out.println(sb);
    }
    private static int calc(int N, int W) {
        Queue<Integer> q = new LinkedList<>();
        int[] dp = new int[N+1];
        for(int i = 1; i <= N; i++) {
            dp[i] = cost[i];
            if (depth[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int n : link.get(cur)) {
                dp[n] = Math.max(dp[n], dp[cur] + cost[n]);
                if(--depth[n] == 0) q.add(n);
            }
        }
        return dp[W];
    }
}