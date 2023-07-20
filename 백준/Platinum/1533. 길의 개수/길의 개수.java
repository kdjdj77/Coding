import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
    	st = new StringTokenizer(br.readLine());
        int N = in(), S = in(), E = in(), T = in(), L = N*5;
        long[][] path = new long[L+1][L+1], res = new long[L+1][L+1];
        for(int i = 1; i <= L; i++) res[i][i] = 1;
        for(int i = 1; i <= N; i++, br.readLine()) {
            for(int j = 0, w; j < N; j++) if ((w = br.read()-'0') > 0) path[i*5][(j+1)*5-w+1] = 1;
            for(int j = 1; j < 5; j++) path[(i-1)*5+j][(i-1)*5+j+1] = 1;
        }
        for(int i = T; i > 0; i /= 2, path = mult(path, path, L)) if (i % 2 == 1) res = mult(res, path, L);
        System.out.print(res[S*5][E*5]);
    }
    static int in() {return Integer.parseInt(st.nextToken());}
    static long[][] mult(long[][] a, long[][] b, int L) {
        long[][] res = new long[L+1][L+1];
        for(int i = 1; i <= L; i++) for(int j = 1; j <= L; j++) for(int k = 1; k <= L; k++)
        	res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % 1000003;
        return res;
    }
}