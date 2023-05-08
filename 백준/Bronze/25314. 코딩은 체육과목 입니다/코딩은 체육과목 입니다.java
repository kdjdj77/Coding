import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = (Integer.parseInt(br.readLine()) - 1) / 4 + 1;
		while(N-- > 0) sb.append("long ");
		sb.append("int");
		System.out.print(sb);
	}
}