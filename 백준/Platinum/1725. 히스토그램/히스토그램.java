import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int H[] = new int[N+1];
		for (int i = 0; i < N; i++) H[i] = Integer.parseInt(br.readLine());
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
		System.out.println(max);
	}
}