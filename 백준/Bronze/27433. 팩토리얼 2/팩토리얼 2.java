import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());
		System.out.print(fact(N));
	}
	public static long fact(long n) {
		return n == 0 ? 1 : n * fact(n-1);
	}
}