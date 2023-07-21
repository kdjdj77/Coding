import java.io.*;
import java.util.*;

public class Main {
    static int order = 1, N[];
    static ArrayList<Integer>[] link;
    static TreeSet<Integer> res = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());
        N = new int[V+1];
        link = new ArrayList[V+1];
        for(int i = 1; i <= V; i++) link[i] = new ArrayList<>();
        for(int i = 0, A, B; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            link[A = Integer.parseInt(st.nextToken())].add(B = Integer.parseInt(st.nextToken()));
            link[B].add(A);
        }
        for(int i = 1; i <= V; i++) if (N[i] == 0) dfs(i, true);
        StringBuilder sb = new StringBuilder().append(res.size()).append("\n");
        for(int i : res) sb.append(i).append(" ");
        System.out.print(sb);
    }
    static int dfs(int cur, boolean isRoot) {
        int min = N[cur] = order++, min2, cnt = 0;
        for (int next : link[cur]) {
            if (N[next] == 0) {
                if ((min2 = dfs(next, false)) >= N[cur] && !isRoot) res.add(cur);
                cnt++;
            } else min2 = N[next];
            min = Math.min(min, min2);
        }
        if (isRoot && cnt >= 2) res.add(cur);
        return min;
    }
}