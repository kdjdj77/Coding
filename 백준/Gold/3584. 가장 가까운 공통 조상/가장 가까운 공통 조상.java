import java.io.*;
import java.util.*;
 
public class Main {
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			parent = new int[N+1];
			for(int i = 1; i <= N; i++) parent[i] = i;
			
			for(int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				parent[e] = s;
			}
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(getLCA(a, b)).append("\n");
		}
		System.out.print(sb);
	}
	static int getLCA(int a, int b) {
		Set<Integer> set = new HashSet<>();
		while(parent[a] != a) {
			set.add(a);
			a = parent[a];
		}
		while(parent[b] != b) {
			if (set.contains(b)) return b;
			b = parent[b];
		}
		return b;
	}
}