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
		int N = Integer.parseInt(br.readLine());
		int maxDepth = 0;
		int check = 1;
		while(check <= N) { // 트리의 깊이 계산
			check <<= 1;
			maxDepth++;
		}
		
		list=new ArrayList<>();
		for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
		depth=new int[N+1];
		parent=new int[N+1][maxDepth+1];
		
		for(int i=0;i<N-1;i++) {
			String[] s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			list.get(a).add(b);
			list.get(b).add(a);
		}
		dfs(1, 1); // 트리 생성
		setParent(N, maxDepth); // 부모 계산
		
		int M=Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			String[] s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			System.out.println(solve(a, b, maxDepth));
			
		}
	}
	
	
	public static void dfs(int node, int cnt) {
		depth[node]=cnt; // node의 깊이 저장
		for(int n:list.get(node)) { // node와 연결된 곳 중
			if(depth[n]!=0) continue; // 방문한 곳은 패스
			parent[n][0]=node; // n의 첫 번째 부모는 node
			dfs(n, cnt+1); // n으로 이동
		}
	}
	
	public static void setParent(int n, int maxDepth) {
		for(int i=1;i<maxDepth;i++) { // 2^i번째 부모 저장
			for(int j=1;j<=n;j++) {
				parent[j][i]=parent[parent[j][i-1]][i-1];
			}
		}
	}
	
	public static int solve(int a, int b, int maxDepth) {
		if(depth[a]>depth[b]) { // a의 깊이가 b보다 더 작도록
			int temp=a;
			a=b;
			b=temp;
		}
		for(int i=maxDepth-1;i>=0;i--) { // a, b가 같은 깊이가 되도록 설정
			if(depth[a]<=depth[parent[b][i]]) b=parent[b][i];
		}
		
		if(a==b) return a;
		// 다르다면
		for(int i=maxDepth-1;i>=0;i--) { // 같이 깊이를 올리며 
			if(parent[a][i]!=parent[b][i]) {
				a=parent[a][i];
				b=parent[b][i];
			}
		}
		return parent[a][0];
	}
}