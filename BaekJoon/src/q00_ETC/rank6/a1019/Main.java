package q00_ETC.rank6.a1019;
/*
문제
지민이는 전체 페이지의 수가 N인 책이 하나 있다. 첫 페이지는 1 페이지이고, 마지막 페이지는 N 페이지이다. 각 숫자가 전체 페이지 번호에서 모두 몇 번 나오는지 구해보자.

입력
첫째 줄에 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 0이 총 몇 번 나오는지, 1이 총 몇 번 나오는지, ..., 9가 총 몇 번 나오는지를 공백으로 구분해 출력한다.
*/

import java.io.*;

public class Main {
	static int cnt[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int s = 1, e = Integer.parseInt(br.readLine()), len = 1;
		cnt = new int[10];
		while(s <= e) {
			while(s%10 != 0 && s <= e) cnt(s++, len);
			while(e%10 != 9 && s <= e) cnt(e--, len);
			if(s > e) break;
			s /= 10; e /= 10;
			for(int i = 0; i < 10; i++) cnt[i] += (e-s+1)*len;
			len *= 10;
		}
		StringBuilder sb = new StringBuilder();
		for(int i : cnt) sb.append(i).append(" ");
		System.out.print(sb);
	}
	static void cnt(int n, int len) {while(n > 0) {cnt[n%10] += len; n /= 10;}}
}
