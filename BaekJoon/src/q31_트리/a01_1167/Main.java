package q31_트리.a01_1167;
/*
문제
루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.

출력
첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
		for(int i = 0; i <= N; i++) tree.add(new ArrayList<>());
		int[] res = new int[N+1];
		
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b); tree.get(b).add(a);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int t : tree.get(cur)) 
				if (res[t] == 0) { res[t] = cur; q.add(t); }
		}
		for(int i = 2; i <= N; i++) sb.append(res[i]).append("\n");
		System.out.print(sb);
	}
}