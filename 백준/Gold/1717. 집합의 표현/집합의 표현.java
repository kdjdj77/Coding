import java.io.*;
import java.util.*;
 
public class Main {
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		A = new int[N+1];
		for(int i = 0; i <= N; i++) A[i] = i;
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if (a == 0) union(x, y);
			else sb.append(isSameRoot(x, y) ? "YES" : "NO").append("\n");
		}
		System.out.print(sb);
	}
	public static int root(int x) {
        if(x == A[x]) return x;
        return A[x] = root(A[x]);
	}
    public static void union(int x, int y) {
        x = root(x); y = root(y);
        if (x == y) return;
        if (x < y) A[y] = x;
        else A[x] = y;
    }
    public static boolean isSameRoot(int x, int y) {
        return root(x) == root(y);
    }
}