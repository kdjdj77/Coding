package q00_ETC.gold1.a1016;
/*
문제
어떤 정수 X가 1보다 큰 제곱수로 나누어 떨어지지 않을 때, 그 수를 제곱ㄴㄴ수라고 한다. 제곱수는 정수의 제곱이다.
min과 max가 주어지면, min보다 크거나 같고, max보다 작거나 같은 제곱ㄴㄴ수가 몇 개 있는지 출력한다.

입력
첫째 줄에 두 정수 min과 max가 주어진다.

출력
첫째 줄에 min보다 크거나 같고, max보다 작거나 같은 제곱ㄴㄴ수의 개수를 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken()), max = Long.parseLong(st.nextToken());
		int res = (int)(max-min) + 1;
		boolean[] check = new boolean[res];
		for(long i = 2; i*i <= max; i++) {
			long pow = i*i, k = min/pow;
			if (min%pow != 0) k += 1;
			for(long j = k; j*pow <= max; j++) {
				int pos = (int)(j*pow-min);
				if (!check[pos]) {check[pos] = true; res--;}
			}
		}
		System.out.print(res);
    }
}