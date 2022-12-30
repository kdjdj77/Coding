package q29_투포인터.a04_1644;

/*
20 0
3 1
41 3
53 2
*/

import java.util.Scanner;
import java.util.ArrayList;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> p = new ArrayList<>();
		for(int i = 2; i < N; i++) if (isPrime(i)) p.add(i);
		int s = 0, e = 0, res = 0, sum = p.get(0), l = p.size();
		while(s < l && e < l) {
			if (sum == N) { 
				if (++e >= l) break;
				sum += p.get(e) - p.get(s++);
				res++; 
			}
			else if (sum < N) sum += p.get(++e);
			else sum -= p.get(s++);
		}
		System.out.print(res);
	}
	private static boolean isPrime(int n) {
		for(int i = 2; i <= Math.sqrt(n); i++)
			if (n % i == 0) return false;
		return true;
	}
}