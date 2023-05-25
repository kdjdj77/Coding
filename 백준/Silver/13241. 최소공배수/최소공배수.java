import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken());
		long x = a*b, re;
		while((re = a%b) != 0) { a = b; b = re; }
		System.out.print(x/b);
	}
}