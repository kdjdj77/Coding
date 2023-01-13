import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] cnt = new int[1000001];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			A[i] = x;
			cnt[x]++;
		}
		
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0; i < N; i++) {
			while(!s.isEmpty() && cnt[A[s.peek()]] < cnt[A[i]]) A[s.pop()] = A[i];
			s.push(i);
		}
		
		while(!s.isEmpty()) A[s.pop()] = -1;
		for(int i = 0; i < N; i++) sb.append(A[i]).append(" ");
		System.out.print(sb);
	}
}