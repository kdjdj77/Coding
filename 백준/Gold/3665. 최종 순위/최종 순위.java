import java.io.*;
import java.util.*;
 
public class Main {
	static int n, m, indegree[];
	static boolean link[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			n = Integer.parseInt(br.readLine());
			indegree = new int[n+1];
			link = new boolean[n+1][n+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				int now = Integer.parseInt(st.nextToken());
				indegree[now] = i;
				for(int j = 1; j <= n; j++)
					if (j != now && !link[j][now])
						link[now][j] = true;
			}
			
			m = Integer.parseInt(br.readLine());
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				if (!link[s][e]) setReverse(s, e);
				else setReverse(e, s);
			}
			sb.append(result());
		}
		System.out.println(sb);
	}
	static void setReverse(int s, int e) {
		link[s][e] = true;
		link[e][s] = false;
		indegree[s]--;
		indegree[e]++;
	}
	static String result() {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) if (indegree[i] == 0) q.add(i);
		
		for (int i = 1; i <= n; i++) {
			if (q.isEmpty()) return "IMPOSSIBLE\n";
			if (q.size() > 1) return "?\n"; 
			
			int s = q.poll();
			sb.append(s).append(" ");
			
			for (int e = 1; e <= n; e++) { 
				if (link[s][e]) {
					link[s][e] = false;
					if (--indegree[e] == 0) q.add(e); 
				}
			}
		}
		return sb.append("\n").toString();
	}
}