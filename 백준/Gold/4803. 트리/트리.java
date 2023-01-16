import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> A;
	static boolean[] visit;
	static boolean isTree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		for(int cnt = 1;; cnt++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0) break;
			
			int res = 0;
			A = new ArrayList<>();
			for(int i = 0; i <= N; i++) A.add(new ArrayList<Integer>());
			
			visit = new boolean[501];
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				A.get(x).add(y); A.get(y).add(x);
			}
			for(int i = 1; i <= N; i++) {
				isTree = true;
				if (!visit[i]) { path(0, i); if (isTree) res++; }
			}
			
			if (res == 0) sb.append("Case ").append(cnt).append(": No trees.").append("\n");
			else if (res == 1) sb.append("Case ").append(cnt).append(": There is one tree.").append("\n");
			else sb.append("Case ").append(cnt).append(": A forest of ").append(res).append(" trees.").append("\n");
		}
		System.out.print(sb);
	}
	public static void path(int before, int num) {
		if (visit[num]) { isTree = false; return; }
		for(int i : A.get(num)) {
			if (i == before) continue;
			visit[num] = true;
			path(num, i);
		}
	}
}