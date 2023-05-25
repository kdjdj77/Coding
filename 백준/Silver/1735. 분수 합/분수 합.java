import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
		
		int num = a*d + c*b, den = b*d, gcd = gcd(num, den);
		System.out.print(sb.append(num/gcd).append(" ").append(den/gcd));
	}
	private static int gcd(int a, int b) { return a%b == 0 ? b : gcd(b, a%b); }
}