import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
 
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> link[] = new ArrayList[N+1], res = new ArrayList<>();
        for(int i = 0; i <= N; i++) link[i] = new ArrayList<>();
 
        int[] need = new int[N+1];
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken()), a = Integer.parseInt(st.nextToken());
            while(K-- > 1) {
                int b = Integer.parseInt(st.nextToken());
                link[a].add(b);
                need[a = b]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) if (need[i] == 0) q.add(i);
        while(!q.isEmpty()) {
            int cur = q.poll();
            res.add(cur);
            for(int next : link[cur]) if (--need[next] == 0) q.add(next);
        }
        if (res.size() != N) sb.append("0");
        else for(int i = 0; i < N; i++) sb.append(res.get(i)).append("\n");
        System.out.print(sb);
    }
}