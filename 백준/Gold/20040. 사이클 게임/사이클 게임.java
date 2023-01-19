import java.io.*;
import java.util.*;
 
public class Main {
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		A = new int[N];
		
		for(int i = 1; i < N; i++) A[i] = i;
		int res = 0;
		
		for(int n = 1; n <= M; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (isSameRoot(x, y)) { res = n; break; }
			union(x, y);
		}
		System.out.print(res);
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