package q34_트리에서의동적계획법.a02_2213;
/*
문제
그래프 G(V, E)에서 정점의 부분 집합 S에 속한 모든 정점쌍이 서로 인접하지 않으면 (정점쌍을 잇는 간선이 없으면) S를 독립 집합(independent set)이라고 한다. 독립 집합의 크기는 정점에 가중치가 주어져 있지 않을 경우는 독립 집합에 속한 정점의 수를 말하고, 정점에 가중치가 주어져 있으면 독립 집합에 속한 정점의 가중치의 합으로 정의한다. 독립 집합이 공집합일 때 그 크기는 0이라고 하자. 크기가 최대인 독립 집합을 최대 독립 집합이라고 한다.

문제는 일반적인 그래프가 아니라 트리(연결되어 있고 사이클이 없는 그래프)와 각 정점의 가중치가 양의 정수로 주어져 있을 때, 최대 독립 집합을 구하는 것이다.

입력
첫째 줄에 트리의 정점의 수 n이 주어진다. n은 10,000이하인 양의 정수이다. 1부터 n사이의 정수가 트리의 정점이라고 가정한다. 둘째 줄에는 n개의 정수 w1, w2, ..., wn이 주어지는데, wi는 정점 i의 가중치이다(1 ≤ i ≤ n). 셋째 줄부터 마지막 줄까지는 간선의 리스트가 주어지는데, 한 줄에 하나의 간선을 나타낸다. 간선은 정점의 쌍으로 주어진다. 입력되는 정수들 사이에는 빈 칸이 하나 있다. 가중치들의 값은 10,000을 넘지 않는 자연수이다.

출력
첫째 줄에 최대 독립집합의 크기를 출력한다. 둘째 줄에는 최대 독립집합에 속하는 정점을 오름차순으로 출력한다. 최대 독립 집합이 하나 이상일 경우에는 하나만 출력하면 된다.
*/

import java.util.*;
import java.io.*;

public class Main {
	static int[] w, dp[];
	static boolean[] select;
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		w = new int[N+1];
		dp = new int[N+1][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) w[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) tree.add(new ArrayList<>());
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		tree.get(0).add(1);

		select = new boolean[N+1];
		sb.append(setDP(0, 0, false)).append("\n");
		
		trace(0, 1, select[1]);
		for(int i = 1; i <= N; i++) if (select[i]) sb.append(i).append(" ");
		System.out.print(sb);
	}
	static int setDP(int root, int cur, boolean isOn) {
		int res = isOn ? w[cur] : 0;
		for (int next : tree.get(cur)) {
			if(root == next) continue;
			
			int off = dp[next][0] = setDP(cur, next, false);
			if (!isOn) {
				int on = dp[next][1] = setDP(cur, next, true);
				select[next] = on > off;
				res += Math.max(on, off);
			} else res += off;
		}
		return res;
	}
	static void trace(int root, int cur, boolean b) {
		select[cur] = b;
		for(int next : tree.get(cur))
			if (root != next)
				trace(cur, next, b ? false : dp[next][1] > dp[next][0]);
	}
}