import java.io.*;
import java.util.*;

public class Main {
    static int N, M, idx[], mov[];
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = in(); M = in();
            idx = new int[N+1]; mov = new int[N+M+1];
            for(int i = 1; i <= N; i++) update((idx[i] = i+M), 1);
            st = new StringTokenizer(br.readLine());
            for(int i = 0, num; i < M; i++) {
                sb.append(res(idx[num = in()]-1)).append(" ");
                update(idx[num], -1);
                update(idx[num] = M-i, 1);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static int in() {return Integer.parseInt(st.nextToken());}
    static void update(int idx, int dif) {while(idx < N+M+1) {mov[idx] += dif; idx += idx & -idx;}}
    static int res(int idx) {return idx > 0 ? mov[idx]+res(idx-(idx&-idx)) : 0;}
}