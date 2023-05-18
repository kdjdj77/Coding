import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = null;
		while((s = br.readLine()) != null && s.length() != 0) sb.append(s).append("\n");
		System.out.print(sb);
	}
}