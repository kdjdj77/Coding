import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N], dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		int max = 1;
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if (A[j] < A[i]) {
					if (dp[i] < dp[j]+1) dp[i] = dp[j]+1;
					if (max < dp[i]) max = dp[i];
				}
			}
		}
		sb.append(max).append("\n");
		Stack<Integer> s = new Stack<>();
		for(int i = N-1; i >= 0; i--) if (dp[i] == max) { s.add(A[i]); max--; }
		while(!s.isEmpty()) sb.append(s.pop()).append(" ");
		System.out.print(sb);
	}
}