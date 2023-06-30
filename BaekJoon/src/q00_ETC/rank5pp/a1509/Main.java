package q00_ETC.rank5pp.a1509;
/*
문제
세준이는 어떤 문자열을 팰린드롬으로 분할하려고 한다. 예를 들어, ABACABA를 팰린드롬으로 분할하면, {A, B, A, C, A, B, A}, {A, BACAB, A}, {ABA, C, ABA}, {ABACABA}등이 있다.

분할의 개수의 최솟값을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 문자열이 주어진다. 이 문자열은 알파벳 대문자로만 이루어져 있고, 최대 길이는 2,500이다.

출력
첫째 줄에 팰린드롬 분할의 개수의 최솟값을 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	static char[] S;
	static int len, dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(dp = new int[len = (S = br.readLine().toCharArray()).length + 1], len--);
        dp[2] = S[dp[0] = 0] == S[dp[1] = 1] ? 1 : 2;
        for(int i = 2; i < len; pal(i, i-1), pal(i-1, i-1), i++) dp[i+1] = Math.min(dp[i+1], dp[i]+1);
        System.out.print(dp[len]);
    }
    static void pal(int s, int e) {
        while(0 < s-- && ++e < len && S[s] == S[e]) dp[e+1] = Math.min(dp[e+1], dp[s]+1);
    }
}