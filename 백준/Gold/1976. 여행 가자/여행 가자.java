import java.io.*;
import java.util.*;
 
public class Main {
	static int[] A;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		A = new int[N+1];
		for(int i = 1; i <= N; i++) A[i] = i;
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++)
				if (Integer.parseInt(st.nextToken()) == 1) union(i, j);
		}
		
		boolean res = true;
		st = new StringTokenizer(br.readLine());
		int r = root(Integer.parseInt(st.nextToken()));
		while(M-- > 1) {
			int next = Integer.parseInt(st.nextToken());
			if (!isSameRoot(r, next)) { res = false; break; }
		}
		System.out.print(res ? "YES" : "NO");
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