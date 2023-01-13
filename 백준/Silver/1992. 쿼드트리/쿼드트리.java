import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	static StringBuffer sb = new StringBuffer();
	static int[][] S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		S = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			String str = br.readLine();
			for(int j = 1; j <= N; j++)
				S[i][j] = (int)str.charAt(j-1) - 48 + S[i-1][j] + S[i][j-1] - S[i-1][j-1];
		}
		calc(0, 0, N, N);
		System.out.print(sb);
	}
	public static void calc(int x1, int y1, int x2, int y2) {
		int mx = (x2+x1)/2, my = (y2+y1)/2;
		int sum = S[y2][x2] - S[y2][x1] - S[y1][x2] + S[y1][x1];
		if (sum == 0) sb.append(0);
		else if (sum == (x2-x1) * (y2-y1)) sb.append(1);
		else {
			sb.append("(");
			calc(x1, y1, mx, my);
			calc(mx, y1, x2, my);
			calc(x1, my, mx, y2);
			calc(mx, my, x2, y2);
			sb.append(")");
		}
	}
}