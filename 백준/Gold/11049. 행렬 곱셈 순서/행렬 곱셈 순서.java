import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] A = new int[N][2];
		int[][] sum = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i][0] = Integer.parseInt(st.nextToken());
			A[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int gap = 1; gap < N; gap++) {
			for(int s = 0; s < N - gap; s++) {
				int e = s + gap;
				sum[s][e] = Integer.MAX_VALUE;
				for(int k = s; k < e; k++) {
					int x = sum[s][k] + sum[k+1][e] + A[s][0] * A[k][1] * A[e][1];
					sum[s][e] = Math.min(sum[s][e], x);
				}
			}
		}
		System.out.println(sum[0][N-1]);
		br.close();
	}
}