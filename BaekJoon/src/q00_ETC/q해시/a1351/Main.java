package q00_ETC.q해시.a1351;
/*
문제
무한 수열 A는 다음과 같다.

A0 = 1
Ai = A⌊i/P⌋ + A⌊i/Q⌋ (i ≥ 1)
N, P와 Q가 주어질 때, AN을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 3개의 정수 N, P, Q가 주어진다.

출력
첫째 줄에 AN을 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	private static Map<Long, Long> dp;
	private static long P, Q;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		
		dp = new HashMap<>();
		dp.put(0L, 1L);
		System.out.print(A(N));
    }
    private static long A(long i) {
    	if (dp.containsKey(i)) return dp.get(i);
    	dp.put(i, A(i/P) + A(i/Q));
    	return dp.get(i);
    }
}