import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	public static int[] q;
	public static int s = 0, e = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int cnt = Integer.parseInt(br.readLine());
		q = new int[cnt];
		
		for(int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
				case "push": push(Integer.parseInt(st.nextToken())); break;
				case "pop": sb.append(pop()).append('\n'); break;
				case "size": sb.append(size()).append('\n'); break;
				case "empty": sb.append(empty()).append('\n'); break;
				case "back": sb.append(back()).append('\n'); break;
				case "front": sb.append(front()).append('\n'); break;
			}
		}
		System.out.print(sb);
	}
	public static void push(int i) { q[e++] = i; }
	public static int size() { return e - s; }
	public static int empty() { return e == s ? 1 : 0; }
	public static int back() { return e == s ? -1 : q[e - 1]; }
	public static int front() { return e == s ? -1 : q[s]; }
	public static int pop() { return e == s ? -1 : q[s++]; }
}