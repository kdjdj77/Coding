package q35_기하2.a08_7869;
/*
문제
두 원이 주어졌을 때, 교차하는 영역의 넓이를 소수점 셋째자리까지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 두 원의 중심과 반지름 x1, y1, r1, x2, y2, r2가 주어진다. 실수는 최대 소수점 둘째자리까지 주어진다.

출력
첫째 줄에 교차하는 영역의 넓이를 반올림해 소수점 셋째자리까지 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double res;
		double[] A = new double[6];
		for(int i = 0; i < 6; i++) A[i] = Double.parseDouble(st.nextToken());

		double D = Math.sqrt(Math.pow(A[3]-A[0], 2) + Math.pow(A[4]-A[1], 2));
		if (D >= A[2] + A[5]) res = 0;
		else if (D <= Math.abs(A[2] - A[5])) res = Math.PI * Math.pow(Math.min(A[2], A[5]), 2);
		else {
			double rad1 = Math.acos(cos(A[2], A[5], D));
			double rad2 = Math.acos(cos(A[5], A[2], D));
			res = area(A[2], rad1) + area(A[5], rad2);
		}
		System.out.printf("%.3f", res);
	}
	static double area(double r, double rad) {
		return r*r*rad - r*r*Math.sin(2*rad)/2;
	}
	static double cos(double r1, double r2, double d) {
		return (r1*r1 + d*d - r2*r2) / (2*r1*d);
	}
}