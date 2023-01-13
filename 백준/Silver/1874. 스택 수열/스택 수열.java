import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int cnt = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		int cur = 1;
		for(int i = 0; i < cnt; i++) {
			int tmp = Integer.parseInt(br.readLine());
			for(int j = cur; j <= tmp; j++) {
				s.push(j);
				cur++;
				sb.append("+\n");
			}
			if (!s.empty() && s.peek() == tmp) {
				s.pop();
				sb.append("-\n");
			} else break;
		}
		if (!s.isEmpty()) System.out.print("NO");
		else System.out.print(sb);
	}
}