import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] ch = new int[] {25, 10, 5, 1};
		while(N-- > 0) {
			int m = Integer.parseInt(br.readLine());
			for(int i = 0; i < 4; i++) {
				sb.append(m / ch[i]).append(" ");
				m %= ch[i];
			} sb.append("\n");
		}
		System.out.print(sb);
	}
}