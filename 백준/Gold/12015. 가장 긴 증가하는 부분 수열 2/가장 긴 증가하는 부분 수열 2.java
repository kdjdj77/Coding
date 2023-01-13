import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N], B = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
 
		B[0] = A[0];
		int len = 1;
		for (int i = 1; i < N; i++) {
			int x = A[i];
			if (B[len-1] < x) B[++len-1] = x;
			else {
				int s = 0, e = len, m;
				while (s < e) {
					m = (s+e)/2;
					if (B[m] < x) s = m + 1;
					else e = m;
				}
				B[s] = x;
			}
		}
		System.out.print(len);
	}
}