import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		double res = 0;
		int N = Integer.parseInt(br.readLine());
		long[][] dots = new long[N+1][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dots[i][0] = Integer.parseInt(st.nextToken());
			dots[i][1] = Integer.parseInt(st.nextToken());
		}
		dots[N][0] = dots[0][0];
		dots[N][1] = dots[0][1];
		for(int i = 0; i < N; i++) res += dots[i][0] * dots[i+1][1] - dots[i][1] * dots[i+1][0];
		System.out.printf("%.1f", Math.abs(res / 2));
	}
}