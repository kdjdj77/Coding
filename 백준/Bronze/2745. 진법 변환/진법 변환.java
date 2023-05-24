import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String num = st.nextToken();
		int base = Integer.parseInt(st.nextToken());
		int len = num.length(), pow = 0, res = 0;
		while(len-- > 0) {
			char c = num.charAt(len);
			int x = c > 47 && c < 58 ? c - 48 : c - 55;
			res += Math.pow(base, pow++) * x;
		}
		System.out.print(res);
	}
}