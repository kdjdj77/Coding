package q00_ETC.rank5pp.a9527;
/*
문제
두 자연수 A, B가 주어졌을 때, A ≤ x ≤ B를 만족하는 모든 x에 대해 x를 이진수로 표현했을 때 1의 개수의 합을 구하는 프로그램을 작성하시오.

즉, f(x) = x를 이진수로 표현 했을 때 1의 개수라고 정의하고, 아래 식의 결과를 구하자.

 
\[\sum_{x=A}^{B}{f(x)}\] 

입력
첫 줄에 두 자연수 A, B가 주어진다. (1 ≤ A ≤ B ≤ 1016)

출력
1의 개수를 세어 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
    static long[] dp = new long[55];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken()), B = Long.parseLong(st.nextToken());
        dp[0] = 1;
        for(int i = 1; i < 55; i++) dp[i] = (dp[i-1]<<1) + (1L<<i);
        System.out.print(calc(B) - calc(A-1));
    }
    static long calc(long X) {
        long res = X & 1;
        for(int i = (int)(Math.log(X)/Math.log(2)); i > 0; i--)
        	if((X & (1L<<i)) != 0) res += dp[i-1] + (X -= (1L<<i)) + 1;
        return res;
    }
}