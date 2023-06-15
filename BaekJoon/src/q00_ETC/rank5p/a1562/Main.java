package q00_ETC.rank5p.a1562;
/*
문제
45656이란 수를 보자.

이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.

N이 주어질 때, 길이가 N이면서 0부터 9까지 숫자가 모두 등장하는 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. 0으로 시작하는 수는 계단수가 아니다.

입력
첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.

출력
첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
*/

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine()), ok = (1<<10)-1, M = 1000000000;
		int dp[][][] = new int[10][N+1][ok+1], res = 0;

		for(int i = 1; i < 10; i++) dp[i][1][1<<i] = 1;
		for(int d = 2; d <= N; d++) for(int n = 0; n < 10; n++) for(int v = 0; v <= ok; v++) {
			int v2 = v | (1<<n);
			if (n != 0) dp[n][d][v2] += dp[n-1][d-1][v] % M;
			if (n != 9) dp[n][d][v2] += dp[n+1][d-1][v] % M;
			dp[n][d][v2] %= M;
		}
		for (int i = 0; i < 10; i++) res = (res + dp[i][N][ok]) % M;
		System.out.print(res);
	}
}


/*

public class Main {
private static final int div = 1000000000;
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()), visit = 0, res = 0;
    for(int i = 1; i < 10; i++) res += dfs(N, BigInteger.valueOf(i), visit | 1<<i, 1);
    System.out.print(res);
}
private static int dfs(int N, BigInteger cur, int visit, int depth) {
	if (depth == N) return visit == (1<<10)-1 ? 1 : 0;
	int res = 0, n1 = cur.remainder(BigInteger.TEN).intValue();
	BigInteger next = cur.multiply(BigInteger.TEN);
	if (n1 != 0) res += dfs(N, next.add(BigInteger.valueOf(n1-1)), visit | 1<<(n1-1), depth+1);
	if (n1 != 9) res += dfs(N, next.add(BigInteger.valueOf(n1+1)), visit | 1<<(n1+1), depth+1);
	return res % div;
}
}
*/