package q00_ETC.rank6p.a11689;
/*
문제
자연수 n이 주어졌을 때, GCD(n, k) = 1을 만족하는 자연수 1 ≤ k ≤ n 의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 n (1 ≤ n ≤ 1012)이 주어진다.

출력
GCD(n, k) = 1을 만족하는 자연수 1 ≤ k ≤ n 의 개수를 출력한다.
*/

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(new BufferedReader(new InputStreamReader(System.in)).readLine()), p=n;
		for(long i=2; i*i<=n; i++) {
			if (n%i==0) p-=p/i;
			while(n%i==0) n/=i;
		}
		System.out.print(n==1?p:p-p/n);
    }
}