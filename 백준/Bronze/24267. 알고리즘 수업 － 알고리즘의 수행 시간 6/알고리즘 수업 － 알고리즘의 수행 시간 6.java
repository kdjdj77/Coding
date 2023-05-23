import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long N = Long.parseLong(br.readLine()) - 2;
        System.out.print(sb.append((N*N*N + 3*N*N + 2*N) / 6).append("\n3"));
	}
}