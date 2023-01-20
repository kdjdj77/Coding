package q34_트리에서의동적계획법.a01_15681;
/*
문제
간선에 가중치와 방향성이 없는 임의의 루트 있는 트리가 주어졌을 때, 아래의 쿼리에 답해보도록 하자.

정점 U를 루트로 하는 서브트리에 속한 정점의 수를 출력한다.
만약 이 문제를 해결하는 데에 어려움이 있다면, 하단의 힌트에 첨부한 문서를 참고하자.

입력
트리의 정점의 수 N과 루트의 번호 R, 쿼리의 수 Q가 주어진다. (2 ≤ N ≤ 105, 1 ≤ R ≤ N, 1 ≤ Q ≤ 105)

이어 N-1줄에 걸쳐, U V의 형태로 트리에 속한 간선의 정보가 주어진다. (1 ≤ U, V ≤ N, U ≠ V)

이는 U와 V를 양 끝점으로 하는 간선이 트리에 속함을 의미한다.

이어 Q줄에 걸쳐, 문제에 설명한 U가 하나씩 주어진다. (1 ≤ U ≤ N)

입력으로 주어지는 트리는 항상 올바른 트리임이 보장된다.

출력
Q줄에 걸쳐 각 쿼리의 답을 정수 하나로 출력한다.
*/

import java.io.*;
import java.util.*;
 
public class Main {
	static ArrayList<ArrayList<Integer>> A = new ArrayList<>();
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1];
		for(int i = 0; i < N+1; i++) A.add(new ArrayList<>());
		
		while(N-- > 1) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			A.get(U).add(V); A.get(V).add(U);
		}
		setCount(0, R);
		
		while(Q-- > 0) sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		System.out.print(sb);
	}
	public static int setCount(int root, int cur) {
		int res = 1;
		for(int a : A.get(cur)) if (a != root) res += setCount(cur, a);
		return dp[cur] = res;
	}
}