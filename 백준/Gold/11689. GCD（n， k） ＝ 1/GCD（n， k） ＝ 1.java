import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine()), p = n;
		for(long i = 2; i*i <= n; i++) {
			if (n % i == 0) p = p/i*(i-1);
			while(n % i == 0) n /= i;
		}
		System.out.print(n == 1 ? p : p/n*(n-1));
    }
}