import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N;
		while((N = Integer.parseInt(br.readLine())) != -1) {
			int sum = 1, idx = 1;
			double sqrt = Math.sqrt(N);
			List<String> divs = new ArrayList<>(); divs.add("1");
			for(int i = 2; i < sqrt; i++) {
				if (N%i != 0) continue;
				sum += i + N/i;
				divs.add(idx, String.valueOf(N/i));
				divs.add(idx++, String.valueOf(i));
			} if (sqrt % 1 == 0) divs.add(idx, String.valueOf((int)sqrt));
			sb.append(N);
			if (sum != N) sb.append(" is NOT perfect.\n");
			else sb.append(" = ").append(String.join(" + ", divs)).append("\n");
		}
		System.out.print(sb);
	}
}