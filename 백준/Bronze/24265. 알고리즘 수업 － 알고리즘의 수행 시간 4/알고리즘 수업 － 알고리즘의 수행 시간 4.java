import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Long N = Long.parseLong(br.readLine()) - 1;
		sb.append(N % 2 == 0 ? (N+1)*(N/2) : (N+1)*(N/2) + N/2 + 1);
		System.out.print(sb.append("\n2"));
	}
}