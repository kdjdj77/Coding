import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, N, D, P, INF = 1000000007;
    public static void main(String[] args) throws IOException {
    	st(0); T = in(); N = in(); D = in(); P = D/T;
		int[][] set = new int[N][N], res = new int[N][N], remain = new int[N][N], bin[] = new int[31][N][N];
    	
    	for(int i = 0; i < N; i++) remain[i][i] = res[i][i] = set[i][i] = 1;
    	for(int t = 0; t < T; t++) {
    		int[][] mx = new int[N][N];
    		for(int i = 0, M = br(); i < M; i++) {st(0); mx[in()-1][in()-1] = in();}
    		if (t < D%T) remain = mult(remain, mx);
    		set = mult(set, mx);
    	}
    	bin[0] = set;
    	for(int i = 1; i < 31; i++) bin[i] = (set = mult(set, set)).clone();
    	for(int i = 30; i >= 0 && P != 0; i--) if (P >= (1<<i)) {P -= 1<<i; res = mult(res, bin[i]);}
    	res = mult(res, remain);
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) sb.append(res[i][j]).append(" ");
    		sb.append("\n");
    	}
    	System.out.print(sb);
    }
    static int br() throws IOException {return Integer.parseInt(br.readLine());}
    static int st(int n) throws IOException {st = new StringTokenizer(br.readLine()); return n;}
    static int in() {return Integer.parseInt(st.nextToken());}
    static int[][] mult(int[][] m1, int[][] m2) {
        int[][] res = new int[N][N];
        for(int i = 0; i < N; i++) for(int j = 0; j < N; j++)
        	for(int k = 0; k < N; k++) {res[i][j] += ((long)m1[i][k]*m2[k][j])%INF; res[i][j] %= INF;}
        return res;
    }
}