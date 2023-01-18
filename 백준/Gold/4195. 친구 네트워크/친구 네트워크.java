import java.io.*;
import java.util.*;
 
public class Main {
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			A = new int[2000001];
			int idx = 0;
			
			Map<String, Integer> map = new HashMap<>();
			int M = Integer.parseInt(br.readLine());
			while(M-- > 0) {
				st = new StringTokenizer(br.readLine());
				String x = st.nextToken();
				String y = st.nextToken();
				if (!map.containsKey(x)) { map.put(x, ++idx); A[idx] = -1; }
				if (!map.containsKey(y)) { map.put(y, ++idx); A[idx] = -1; }
				union(map.get(x), map.get(y));
				sb.append(Math.abs(A[root(map.get(x))])).append("\n");
			}
		}
		System.out.print(sb);
	}
	public static int root(int x) {
		return A[x] < 0 ? x : root(A[x]);
	}
	public static void union(int x, int y) {
        x = root(x); y = root(y);
        if (x == y) return;
        if (A[x] < A[y]) { A[x] += A[y]; A[y] = x; }
        else { A[y] += A[x]; A[x] = y; }
    }
}