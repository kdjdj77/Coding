package q35_기하2.a02_11758;
/*
문제
2차원 좌표 평면 위에 있는 점 3개 P1, P2, P3가 주어진다. P1, P2, P3를 순서대로 이은 선분이 어떤 방향을 이루고 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 P1의 (x1, y1), 둘째 줄에 P2의 (x2, y2), 셋째 줄에 P3의 (x3, y3)가 주어진다. (-10,000 ≤ x1, y1, x2, y2, x3, y3 ≤ 10,000) 모든 좌표는 정수이다. P1, P2, P3의 좌표는 서로 다르다.

출력
P1, P2, P3를 순서대로 이은 선분이 반시계 방향을 나타내면 1, 시계 방향이면 -1, 일직선이면 0을 출력한다.
*/

import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int res = 0;
		int[][] dots = new int[4][2];
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			dots[i][0] = Integer.parseInt(st.nextToken());
			dots[i][1] = Integer.parseInt(st.nextToken());
		}
		dots[3][0] = dots[0][0];
		dots[3][1] = dots[0][1];
		for(int i = 0; i < 3; i++) res += dots[i][0] * dots[i+1][1] - dots[i][1] * dots[i+1][0];
		if (res != 0) res /= Math.abs(res);
		System.out.print(res);
	}
}