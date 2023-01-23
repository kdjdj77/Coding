import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int res = 0;
		int[][] dots = new int[4][2];
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			dots[i][0] = Integer.parseInt(st.nextToken());
			dots[i][1] = Integer.parseInt(st.nextToken());
		}
		dots[3][0] = dots[0][0];
		dots[3][1] = dots[0][1];
		for(int i = 0; i < 3; i++) res += dots[i][0] * dots[i+1][1] - dots[i][1] * dots[i+1][0];
		if (res != 0) res /= Math.abs(res);
		System.out.print(res);
	}
}