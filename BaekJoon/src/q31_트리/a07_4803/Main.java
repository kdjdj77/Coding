package q31_트리.a07_4803;
/*
문제
그래프는 정점과 간선으로 이루어져 있다. 두 정점 사이에 경로가 있다면, 두 정점은 연결되어 있다고 한다. 
연결 요소는 모든 정점이 서로 연결되어 있는 정점의 부분집합이다. 그래프는 하나 또는 그 이상의 연결 요소로 이루어져 있다.

트리는 사이클이 없는 연결 요소이다. 트리에는 여러 성질이 있다. 
예를 들어, 트리는 정점이 n개, 간선이 n-1개 있다. 또, 임의의 두 정점에 대해서 경로가 유일하다.

그래프가 주어졌을 때, 트리의 개수를 세는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 
각 테스트 케이스의 첫째 줄에는 n ≤ 500과 m ≤ n(n-1)/2을 만족하는 정점의 개수 n과 간선의 개수 m이 주어진다. 
다음 m개의 줄에는 간선을 나타내는 두 개의 정수가 주어진다. 같은 간선은 여러 번 주어지지 않는다. 
정점은 1번부터 n번까지 번호가 매겨져 있다. 입력의 마지막 줄에는 0이 두 개 주어진다.

출력
입력으로 주어진 그래프에 트리가 
없다면 "No trees."를, 
한 개라면 "There is one tree."를, 
T개(T > 1)라면 "A forest of T trees."를 테스트 케이스 번호와 함께 출력한다.
*/

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