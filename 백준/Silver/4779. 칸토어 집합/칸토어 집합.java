import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String in;
		while((in = br.readLine()) != null)
			sb.append(can((int)Math.pow(3, Integer.parseInt(in)))).append("\n");
		System.out.print(sb);
	}
	private static String can(int N) {
		if (N == 1) return "-";
		String s = can(N/3);
		return new StringBuilder().append(s).append(" ".repeat(N/3)).append(s).toString();
	}
}