package q39_최소공통조상.a03_11438;
/*
문제
N(2 ≤ N ≤ 100,000)개의 정점으로 이루어진 트리가 주어진다. 트리의 각 정점은 1번부터 N번까지 번호가 매겨져 있으며, 루트는 1번이다.

두 노드의 쌍 M(1 ≤ M ≤ 100,000)개가 주어졌을 때, 두 노드의 가장 가까운 공통 조상이 몇 번인지 출력한다.

입력
첫째 줄에 노드의 개수 N이 주어지고, 다음 N-1개 줄에는 트리 상에서 연결된 두 정점이 주어진다. 그 다음 줄에는 가장 가까운 공통 조상을 알고싶은 쌍의 개수 M이 주어지고, 다음 M개 줄에는 정점 쌍이 주어진다.

출력
M개의 줄에 차례대로 입력받은 두 정점의 가장 가까운 공통 조상을 출력한다.
*/

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
		if (depth[a] > depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		for(int i = maxFloor-1; i >= 0; i--)
			if (depth[a] <= depth[parent[b][i]]) b = parent[b][i];
		
		if(a == b) return a;
		for(int i = maxFloor-1; i >= 0; i--) {
			if (parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		return parent[a][0];
	}
}