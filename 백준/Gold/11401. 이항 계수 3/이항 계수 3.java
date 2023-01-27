import java.util.Scanner;
 
public class Main {
	final static long t = 1000000007;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long N = s.nextLong();
		long K = s.nextLong();
		System.out.print(f(N) * p(f(K) * f(N - K) % t, t - 2) % t);
	}
	public static long f(long N) {
		long r = 1L;
		while(N > 1) r = (r * N--) % t;
		return r;
	}
	public static long p(long a, long n) {
		if(n == 1) return a % t;
		long d = p(a, n / 2);
		if(n % 2 == 1) return (d * d % t) * a % t;
		return d * d % t;
	}
}