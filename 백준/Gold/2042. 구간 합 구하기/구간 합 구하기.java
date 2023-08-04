import java.io.*;
import java.util.*;

public class Main {
	static long[] num, tree;
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
    	st = new StringTokenizer(br.readLine());
        int N = in(), MK = in() + in();
        num = new long[N+1]; tree = new long[N+1];
        for(int i = 1; i <= N; i++) update(i, num[i] = Long.parseLong(br.readLine()), N);
        for(int i = 0; i < MK; i++){
        	st = new StringTokenizer(br.readLine());
            int a = in(), b = in();
            if (a == 1) {
                long c = Long.parseLong(st.nextToken()), dif = c - num[b];
                num[b] = c;
                update(b, dif, N);
            } else sb.append(res(in()) - res(b-1)).append('\n');
        }
        System.out.print(sb);
    }
    static int in() {return Integer.parseInt(st.nextToken());}
    static void update(int idx, long dif, int N) {while(idx <= N) {tree[idx] += dif; idx += (idx & -idx);}}
    static long res(int idx) {
        long sum = 0;
        while(idx > 0) {
            sum += tree[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }
}