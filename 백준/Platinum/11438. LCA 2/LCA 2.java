import java.io.*;
import java.util.*;

class Main {
	static ArrayList<ArrayList<Integer>> list;
	static int depth[], parent[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int maxFloor = 0;
		for(int i = 1; i < N; i *= 2) maxFloor++;
		
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) list.add(new ArrayList<>());
		depth = new int[N+1];
		parent = new int[N+1][maxFloor+1];
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		setTree(1, 1);
		setParent(N, maxFloor);
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(res(a, b, maxFloor)).append("\n");
		}
		System.out.print(sb);
	}
	static void setTree(int node, int floor) {
		depth[node] = floor;
		for(int n : list.get(node)) {
			if (depth[n] != 0) continue;
			parent[n][0] = node;
			setTree(n, floor+1);
		}
	}
	static void setParent(int n, int maxFloor) {
		for(int i = 1; i < maxFloor; i++)
			for(int j = 1; j <= n; j++)
				parent[j][i] = parent[parent[j][i-1]][i-1];
	}
	static int res(int a, int b, int maxFloor) {
		if(depth[a] > depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		for(int i = maxFloor-1; i >= 0; i--)
			if (depth[a] <= depth[parent[b][i]]) b = parent[b][i];
		
		if(a == b) return a;
		for(int i = maxFloor-1; i >= 0; i--) {
			if(parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		return parent[a][0];
	}
}