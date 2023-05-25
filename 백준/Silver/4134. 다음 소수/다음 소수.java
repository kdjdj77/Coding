import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			BigInteger n = new BigInteger(String.valueOf(br.readLine()));
			sb.append(n.isProbablePrime(10) ? n : n.nextProbablePrime()).append("\n");
		}
		System.out.print(sb);
	}
}