import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int l = -1, r = s.length();
		while(l++ < r--) if (s.charAt(l) != s.charAt(r)) {
			System.out.print(0);
			return;
		}
		System.out.print(1);
	}
}