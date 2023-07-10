import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, top, H[], up[][], dist[][];
    static Map<Integer, Integer>[] link;
    public static void main(String[] args) throws IOException {
    	StringBuilder sb = new StringBuilder();
        link = new HashMap[(N = Integer.parseInt(br.readLine()))+1];
        for(int i = 1; i <= N; i++) link[i] = new HashMap<>();
        for(int i = 1, a, b, w; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
            link[a=in()].put(b=in(), w=in()); link[b].put(a, w);
        }
        for(int i = 0; N>>i != 0; i++) top = i+1;
        H = new int[N+1]; dist = new int[N+1][top]; up = new int[N+1][top];
        dfs(1, H[1] = 1);
        for(int h = 1; h < top; h++) for(int n = 1; n <= N; n++) {
            up[n][h] = up[up[n][h-1]][h-1];
            dist[n][h] = dist[n][h-1] + dist[up[n][h-1]][h-1];
        }
        M = Integer.parseInt(br.readLine());
        while(M-- > 0) {
        	st = new StringTokenizer(br.readLine());
            int a = in(), b = in(), a2 = a, b2 = b, res = 0;
            if (H[a] < H[b]) {int t = a; a = b; b = t;}
            for(int i = top-1; i >= 0; i--) if (1<<i <= H[a]-H[b]) a = up[a][i];
            for(int i = top-1; i >= 0; i--) if (up[a][i] != up[b][i]) {a = up[a][i]; b = up[b][i];}
            for(int i = top-1, lca = a == b ? a : up[a][0]; i >= 0; i--) {
            	if (1<<i <= H[a2]-H[lca]) {res += dist[a2][i]; a2 = up[a2][i];}
            	if (1<<i <= H[b2]-H[lca]) {res += dist[b2][i]; b2 = up[b2][i];}
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }
	static int in() {return Integer.parseInt(st.nextToken());}
    static void dfs(int n, int h) {
        for(int num : link[n].keySet()) if (H[num] == 0) {
            dfs(num, H[num] = h+1);
            dist[num][0] = link[num].get(up[num][0] = n);
        }
    }
}