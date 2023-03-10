package q30_동적계획법과최단거리역추적.a09_11780;
/*
문제
n(1 ≤ n ≤ 100)개의 도시가 있다. 
그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1 ≤ m ≤ 100,000)개의 버스가 있다. 
각 버스는 한 번 사용할 때 필요한 비용이 있다.

모든 도시의 쌍 (A, B)에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 도시의 개수 n이 주어지고 둘째 줄에는 버스의 개수 m이 주어진다. 
그리고 셋째 줄부터 m+2줄까지 다음과 같은 버스의 정보가 주어진다. 
먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다. 
버스의 정보는 버스의 시작 도시 a, 도착 도시 b, 한 번 타는데 필요한 비용 c로 이루어져 있다. 
시작 도시와 도착 도시가 같은 경우는 없다. 비용은 100,000보다 작거나 같은 자연수이다.

출력
먼저, n개의 줄을 출력해야 한다. i번째 줄에 출력하는 j번째 숫자는 도시 i에서 j로 가는데 필요한 최소 비용이다. 
만약, i에서 j로 갈 수 없는 경우에는 그 자리에 0을 출력한다.

그 다음에는 n×n개의 줄을 출력해야 한다. 
i×n+j번째 줄에는 도시 i에서 도시 j로 가는 최소 비용에 포함되어 있는 도시의 개수 k를 출력한다. 
그 다음, 도시 i에서 도시 j로 가는 경로를 공백으로 구분해 출력한다. 이때, 도시 i와 도시 j도 출력해야 한다. 
만약, i에서 j로 갈 수 없는 경우에는 0을 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][N+1];
		int[][] path = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= N; j++)
				if (i != j) dp[i][j] = INF;
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (dp[a][b] > c) dp[a][b] = c;
			path[a][b] = a;
		}
		for(int m = 1; m <= N; m++)
			for(int s = 1; s <= N; s++)
				for(int e = 1; e <= N; e++)
					if (dp[s][e] > dp[s][m] + dp[m][e]) { 
						dp[s][e] = dp[s][m] + dp[m][e];
						path[s][e] = path[m][e];
					}
					
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) 
				sb.append(dp[i][j] == INF ? 0 : dp[i][j]).append(" ");
			sb.append("\n");
		}
		
		for(int s = 1; s <= N; s++) {
			for (int e = 1; e <= N; e++) {
				int p = path[s][e];
				if (s == e || p == 0) { sb.append(0).append("\n"); continue; }

				Stack<Integer> S = new Stack<>();
				while (p != 0) { S.push(p); p = path[s][p]; }
				
				sb.append(S.size() + 1).append(" ");
				while (!S.empty()) sb.append(S.pop()).append(" ");
				sb.append(e).append("\n");
			}
		}
		System.out.print(sb);
	}
}