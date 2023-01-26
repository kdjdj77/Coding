package q36_동적계획법3.a02_1311;
/*
문제
N명의 사람과 N개의 일이 있다. 각 사람은 일을 하나 담당해야 하고, 각 일을 담당하는 사람은 한 명 이어야 한다. 또한, 모든 사람은 모든 일을 할 능력이 있다.

사람은 1번부터 N번까지 번호가 매겨져 있으며, 일도 1번부터 N번까지 번호가 매겨져 있다.

Dij를 i번 사람이 j번 일을 할 때 필요한 비용이라고 했을 때, 모든 일을 하는데 필요한 비용의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 사람과 일의 수 N (1 ≤ N ≤ 20)이 주어진다. 둘째 줄부터 N개의 줄에는 D의 내용이 주어진다. 비용은 10,000보다 작거나 같은 자연수이다.

출력
모든 일을 하는데 필요한 비용의 최솟값을 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int N, dp[][], graph[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		dp = new int[N][1 << N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) graph[i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.print(res(0, 0));
	}
	static int res(int w, int e) {
		if (w == N) return 0;
		if (dp[w][e] != 0) return dp[w][e];

		int res = INF;
		for (int i = 0; i < N; i++)
			if ((e & (1<<i)) == 0)
				res = Math.min(res, graph[w][i] + res(w+1, e | (1<<i)));
		
		return dp[w][e] = res;
	}
}