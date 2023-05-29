package q11_재귀함수.a_27433;
/*
문제
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N(0 ≤ N ≤ 20)이 주어진다.

출력
첫째 줄에 N!을 출력한다.
 */

import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(fact(Integer.parseInt(br.readLine())));
	}
	public static long fact(int n) {
		return n == 0 ? 1 : n * fact(n-1);
	}
}