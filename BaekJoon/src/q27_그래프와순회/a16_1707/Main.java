package q27_그래프와순회.a16_1707;
/*
문제
그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때, 그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.

그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 구성되어 있는데, 첫째 줄에 테스트 케이스의 개수 K가 주어진다. 각 테스트 케이스의 첫째 줄에는 그래프의 정점의 개수 V와 간선의 개수 E가 빈 칸을 사이에 두고 순서대로 주어진다. 각 정점에는 1부터 V까지 차례로 번호가 붙어 있다. 이어서 둘째 줄부터 E개의 줄에 걸쳐 간선에 대한 정보가 주어지는데, 각 줄에 인접한 두 정점의 번호 u, v (u ≠ v)가 빈 칸을 사이에 두고 주어진다. 

출력
K개의 줄에 걸쳐 입력으로 주어진 그래프가 이분 그래프이면 YES, 아니면 NO를 순서대로 출력한다.

제한
2 ≤ K ≤ 5
1 ≤ V ≤ 20,000
1 ≤ E ≤ 200,000
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static int visit[];
	static ArrayList<ArrayList<Integer>> A;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			visit = new int[V+1];
			
			A = new ArrayList<>();
			for(int i = 0; i <= V; i++) A.add(new ArrayList<Integer>());

			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				A.get(x).add(y); A.get(y).add(x);
			}
			binChk();
		}
		System.out.print(sb);
	}

	public static void binChk() {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i <= V; i++) {
			if(visit[i] == 0) { q.add(i); visit[i] = 1; }

			while(!q.isEmpty()) {
				int cur = q.poll();
				int len = A.get(cur).size();

				for(int j = 0; j < len; j++) {
					int next = A.get(cur).get(j);
					
					if (visit[next] == visit[cur]) { sb.append("NO\n"); return; }
					if (visit[next] == 0) {
						q.add(next);
						if(visit[cur] == 1) visit[next] = 2;
						else visit[next] = 1;
					}
				}
			}
		}
		sb.append("YES\n");
	}
}