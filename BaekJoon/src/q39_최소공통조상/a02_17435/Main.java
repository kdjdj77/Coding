package q39_최소공통조상.a02_17435;
/*
문제
함수 f : {1, 2, ..., m}→{1, 2, ..., m}이 있다. 이때 fn : {1, 2, ..., m}→{1, 2, ..., m}을 다음과 같이 정의하자.

f1(x) = f(x)
fn+1(x) = f(fn(x))
예를 들어 f4(1) = f(f(f(f(1))))이다.

n과 x가 주어질 때 fn(x)를 계산하는 쿼리를 수행하는 프로그램을 작성하시오.

입력
첫 줄에 정수 m이 주어진다. (1 ≤ m ≤ 200,000)

다음 줄에 f(1), f(2), ..., f(m)이 차례대로 주어진다.

다음 줄에 쿼리의 개수 Q가 주어진다. (1 ≤ Q ≤ 200,000)

다음 Q개의 줄에 각각 정수 n과 x가 주어진다. (1 ≤ n ≤ 500,000; 1 ≤ x ≤ m)

출력
주어지는 n, x마다 fn(x)를 출력한다.
*/

import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
        int N = Integer.parseInt(br.readLine());
        int log = 19;
        int[][] dp = new int[log+1][N+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) dp[0][i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= log; i++)
            for (int j = 1; j <= N; j++)
                dp[i][j] = dp[i-1][dp[i-1][j]];

        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            log = 19;
            while(log-- > 0) {
                int cur = (1 << log);
                if (n >= cur) {
                    x = dp[log][x];
                    n -= cur;
                    if (n == 0) break;
                }
            }
            sb.append(x).append("\n");
        }
        System.out.print(sb);
    }
}