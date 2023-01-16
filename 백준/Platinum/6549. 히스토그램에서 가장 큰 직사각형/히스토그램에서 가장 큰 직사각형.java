import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if (N == 0) break;
			
			int H[] = new int[N+1];
			for (int i = 0; i < N; i++) H[i] = Integer.parseInt(st.nextToken());
			H[N] = 0;
			
			Stack<Integer> S = new Stack<>();
			long max = -1;
			for (int i = 0; i <= N; i++) {	
				while (!S.isEmpty() && H[S.peek()] >= H[i]) {
					int x = S.pop();
					int w = S.isEmpty() ? i : i - S.peek() - 1;
					max = Math.max(max, (long)w * H[x]);
				}
				S.push(i);
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}