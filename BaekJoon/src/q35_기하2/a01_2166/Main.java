package q35_기하2.a01_2166;
/*
문제
2차원 평면상에 N(3 ≤ N ≤ 10,000)개의 점으로 이루어진 다각형이 있다. 이 다각형의 면적을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. 다음 N개의 줄에는 다각형을 이루는 순서대로 N개의 점의 x, y좌표가 주어진다. 좌표값은 절댓값이 100,000을 넘지 않는 정수이다.

출력
첫째 줄에 면적을 출력한다. 면적을 출력할 때에는 소수점 아래 둘째 자리에서 반올림하여 첫째 자리까지 출력한다.
*/

import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		double res = 0;
		int N = Integer.parseInt(br.readLine());
		long[][] dots = new long[N+1][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dots[i][0] = Integer.parseInt(st.nextToken());
			dots[i][1] = Integer.parseInt(st.nextToken());
		}
		dots[N][0] = dots[0][0];
		dots[N][1] = dots[0][1];
		for(int i = 0; i < N; i++) res += dots[i][0] * dots[i+1][1] - dots[i][1] * dots[i+1][0];
		System.out.printf("%.1f", Math.abs(res / 2));
	}
}