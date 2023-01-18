package q15_정수론조합론.a08_11051;
/*
문제
자연수 \(N\)과 정수 \(K\)가 주어졌을 때 이항 계수 
\(\binom{N}{K}\)를 10,007로 나눈 나머지를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 \(N\)과 \(K\)가 주어진다. (1 ≤ \(N\) ≤ 1,000, 0 ≤ \(K\) ≤ \(N\))

출력
 
\(\binom{N}{K}\)를 10,007로 나눈 나머지를 출력한다.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if (K > N / 2) K = N - K;
		dp = new int[N + 1][K + 1];
		System.out.println(calc(N, K));
	}
	static int calc(int N, int K) {
		if (dp[N][K] > 0) return dp[N][K];
		if (K == 0 || N == K) return dp[N][K] = 1;
		return dp[N][K] = (calc(N - 1, K - 1) + calc(N - 1, K)) % 10007;
	}
}