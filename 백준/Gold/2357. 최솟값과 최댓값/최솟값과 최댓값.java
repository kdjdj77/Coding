import java.io.*;
import java.util.*;

public class Main {
	private static int in[], seg[][], INF = 1234567890;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        in = new int[N];
        for(int i = 0; i < N; i++) in[i] = Integer.parseInt(br.readLine());
        
        seg = new int[2][(int)Math.pow(2, Math.ceil(Math.log(N)/Math.log(2))+1)];
        Arrays.fill(seg[0], INF);
        set(1, 0, N-1, 0); set(1, 0, N-1, 1);
        
        while(M-- > 0) {
        	st = new StringTokenizer(br.readLine());
        	int l = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
        	sb.append(res(1, 0, N-1, --l, --r, 0)).append(" ").append(res(1, 0, N-1, l, r, 1)).append("\n");
        }
        System.out.print(sb);
    }
    private static int set(int rt, int s, int e, int z) {
    	if (s == e) return seg[z][rt] = in[s];
        int m = (s+e)/2, n1 = set(rt*2, s, m, z), n2 = set(rt*2+1, m+1, e, z);
        return seg[z][rt] = z == 0 ? Math.min(n1, n2) : Math.max(n1, n2);
    }
    private static int res(int rt, int s, int e, int l, int r, int z) {
        if (e < l || r < s) return z == 0 ? INF : 0;
        if (l <= s && e <= r) return seg[z][rt];
        int m = (s+e)/2, n1 = res(rt*2, s, m, l, r, z), n2 = res(rt*2 + 1, m + 1, e, l, r, z);
        return z == 0 ? Math.min(n1, n2) : Math.max(n1, n2);
    }
}