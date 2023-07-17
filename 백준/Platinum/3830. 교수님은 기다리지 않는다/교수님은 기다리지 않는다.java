import java.io.*;
import java.util.*;

public class Main {
    static int[] link, W;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
    	StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            int N = in(), M = in();
            if (N == 0 && M == 0) break;

            W = new int[N+1];
            link = new int[N+1];
            for(int i = 0; i <= N; i++) link[i] = i;
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = st.nextToken().charAt(0), a = in(), b = in();
                if (cmd == '!') union(a, b, in());
                else sb.append(root(a) != root(b) ? "UNKNOWN" : (W[b] - W[a])).append("\n");
            }
        }
        System.out.print(sb);
    }
    static int in() {return Integer.parseInt(st.nextToken());}
    static void union(int a, int b, int w){
        int ra = root(a), rb = root(b);
        if (ra != rb) {link[rb] = ra; W[rb] -= W[b]-W[a]-w;}
    }
    static int root(int n){
        if (link[n] == n) return n;
        int before = root(link[n]);
        W[n] += W[link[n]];
        return link[n] = before;
    }
}