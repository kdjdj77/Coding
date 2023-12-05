import java.io.*;
import java.util.*;

public class Main {
	static int N, W, a[], b[], c[], e[][];
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		Reader fr = new Reader();
		int T = fr.in();
		while(T-- > 0) {
			int res = Integer.MAX_VALUE;
			e = new int[2][N = fr.in()]; W = fr.in();
			
			for(int j = 0; j < 2; j++) for(int k = 0; k < N; k++) e[j][k] = fr.in();
			a = new int[N]; b = new int[N]; c = new int[N+1];
			a[0] = b[0] = 1;
			calc(0);
			
			res = Math.min(res, c[N]);
			if (N > 1) {
				if (e[0][0] + e[0][N-1] <= W && e[1][0] + e[1][N-1] <= W) {
					set(1, 1, 0);
					res = Math.min(res, c[N-1] + 2);
				}
				if (e[0][0] + e[0][N-1] <= W) {
					set(2, e[1][0] + e[1][1] > W ? 2 : 1, 1);
					res = Math.min(res, b[N-1] + 1);
				}
				if (e[1][0] + e[1][N-1] <= W) {
					set(e[0][0] + e[0][1] > W ? 2 : 1, 2, 1);
					res = Math.min(res, a[N-1] + 1);
				}
			}
			sb.append(res).append("\n");
		}
		System.out.print(sb);
	}
	static void set(int n1, int n2, int n3) {a[1] = n1; b[1] = n2; c[1] = n3; calc(1);}
	static void calc(int n) {
		for(int i = n; i < N; i++) {
			c[i+1] = Math.min(a[i] + 1, b[i] + 1);
			if (e[0][i] + e[1][i] <= W) c[i+1] = Math.min(c[i+1], c[i] + 1);
			if (i > 0 && e[0][i-1] + e[0][i] <= W && e[1][i-1] + e[1][i] <= W)
				c[i+1] = Math.min(c[i+1], c[i-1] + 2);
			if (i < N-1) {
				b[i+1] = a[i+1] = c[i+1] + 1;
				if (e[0][i] + e[0][i+1] <= W) a[i+1] = Math.min(a[i+1], b[i] + 1);
				if (e[1][i] + e[1][i+1] <= W) b[i+1] = Math.min(b[i+1], a[i] + 1);
			}
		}
	}
}
class Reader {
	BufferedReader br; StringTokenizer st;
    Reader(){br=new BufferedReader(new InputStreamReader(System.in));}
    String ns(){if(st==null||!st.hasMoreTokens())try{st=new StringTokenizer(br.readLine());}catch(IOException e){}return st.nextToken();}
    int in(){return Integer.parseInt(ns());}
}