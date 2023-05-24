import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Long N = Long.parseLong(br.readLine());
		System.out.print(sb.append(N*N*N).append("\n3"));
	}
}