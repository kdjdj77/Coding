package q00_ETC.rank6.a1761;
/*
문제
N(2 ≤ N ≤ 40,000)개의 정점으로 이루어진 트리가 주어지고 M(1 ≤ M ≤ 10,000)개의 두 노드 쌍을 입력받을 때 두 노드 사이의 거리를 출력하라.

입력
첫째 줄에 노드의 개수 N이 입력되고 다음 N-1개의 줄에 트리 상에 연결된 두 점과 거리를 입력받는다. 그 다음 줄에 M이 주어지고, 다음 M개의 줄에 거리를 알고 싶은 노드 쌍이 한 줄에 한 쌍씩 입력된다. 두 점 사이의 거리는 10,000보다 작거나 같은 자연수이다.

정점은 1번부터 N번까지 번호가 매겨져 있다.

출력
M개의 줄에 차례대로 입력받은 두 노드 사이의 거리를 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, top = 1, H[], D[], P[][];
    static List<Map<Integer, Integer>> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i <= N; i++) tree.add(new HashMap<>());
        for(int i = 0, a, b, w; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            tree.get(a = in()).put(b = in(), w = in());
            tree.get(b).put(a, w);
        }
        for(int i = 1; i < N; i *= 2) top++;
        H = new int[N+1]; D = new int[N+1]; P = new int[N+1][top];
        dfs(1, H[1] = 1);
        for(int h = 1; h < top; h++) for(int n = 1; n <= N; n++) P[n][h] = P[P[n][h-1]][h-1];
        M = Integer.parseInt(br.readLine());
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = in(), b = in(), lca = lca(a, b);
            sb.append(D[a] + D[b] - D[lca]*2).append('\n');
        }
        System.out.print(sb);
    }
    static int in() {return Integer.parseInt(st.nextToken());}
    static int lca(int a, int b) {
        if (H[a] < H[b]) return lca(b, a);
        for(int i = 0; i < top; i++) if (((H[a]-H[b])&(1<<i)) != 0) a = P[a][i];
        if (a == b) return a;
        for(int i = top-1; i >= 0; i--) if (P[a][i] != P[b][i]) {a = P[a][i]; b = P[b][i];}
        return P[a][0];
    }
    static void dfs(int cur, int h) {
        for(int next : tree.get(cur).keySet()) if (H[next] == 0) {
            D[next] = D[P[next][0] = cur] + tree.get(cur).get(next);
            dfs(next, H[next] = h+1);
        }
    }
}
