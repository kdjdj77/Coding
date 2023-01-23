package q35_기하2.a04_17386;
/*
문제
2차원 좌표 평면 위의 두 선분 L1, L2가 주어졌을 때, 두 선분이 교차하는지 아닌지 구해보자.

L1의 양 끝 점은 (x1, y1), (x2, y2), L2의 양 끝 점은 (x3, y3), (x4, y4)이다.

입력
첫째 줄에 L1의 양 끝 점 x1, y1, x2, y2가, 둘째 줄에 L2의 양 끝 점 x3, y3, x4, y4가 주어진다. 세 점이 일직선 위에 있는 경우는 없다.

출력
L1과 L2가 교차하면 1, 아니면 0을 출력한다.

제한
-1,000,000 ≤ x1, y1, x2, y2, x3, y3, x4, y4 ≤ 1,000,000
x1, y1, x2, y2, x3, y3, x4, y4는 정수
선분의 길이는 0보다 크다.
*/

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st, st2;

		int[] a = new int[4], b = new int[4];
		st = new StringTokenizer(br.readLine());
		st2 = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st2.nextToken());
		}

		boolean check1 = ccw(a,b[0],b[1]) * ccw(a,b[2],b[3]) < 0;
		boolean check2 = ccw(b,a[0],a[1]) * ccw(b,a[2],a[3]) < 0;
		System.out.print(check1 && check2 ? 1 : 0);
	}
	public static int ccw(int[] a, long x, long y) {
		long res = 0;
		res += (long)a[0]*a[3] + a[2]*y + x*a[1];
		res -= (long)a[1]*a[2] + a[3]*x + y*a[0];
		return res > 0 ? 1 : -1;
	}
}