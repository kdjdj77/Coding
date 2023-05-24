import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			String s = br.readLine();
			sb.append(s.charAt(0)).append(s.charAt(s.length()-1)).append("\n");
		}
		System.out.print(sb);
	}
}