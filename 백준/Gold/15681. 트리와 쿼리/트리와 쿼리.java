import java.io.*;
import java.util.*;
 
public class Main {
	static ArrayList<ArrayList<Integer>> A = new ArrayList<>();
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1];
		for(int i = 0; i < N+1; i++) A.add(new ArrayList<>());
		
		while(N-- > 1) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			A.get(U).add(V); A.get(V).add(U);
		}
		setCount(0, R);
		
		while(Q-- > 0) sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		System.out.print(sb);
	}
	public static int setCount(int root, int cur) {
		int res = 1;
		for(int a : A.get(cur)) {
			if (a == root) continue;
			res += setCount(cur, a);
		}
		return dp[cur] = res;
	}
}