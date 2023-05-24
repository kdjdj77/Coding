package q06_문자열.a_2444;
/*
문제
예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.

입력
첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

출력
첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
 */

import java.io.*;

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int k = N-1; k >= 0; k--) set(k, N);
		for(int k = 1; k < N; k++) set(k, N);
        System.out.print(sb);
	}
    private static void set(int k, int N) {
    	int len = N*2-1;
    	for(int i = 0; i < k; i++) sb.append(" ");
		for(int i = 0; i < len-2*k; i++) sb.append("*");
		sb.append("\n");
    }
}