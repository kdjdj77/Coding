import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()), idx = 0, deque[] = new int[2];
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			switch(cmd) {
				case 1:
					if (idx >= deque.length) deque = Arrays.copyOf(deque, deque.length<<1);
					deque[idx++] = Integer.parseInt(st.nextToken());
					break;
				case 2: sb.append(idx > 0 ? deque[--idx] : -1).append("\n"); break;
				case 3: sb.append(idx).append("\n"); break;
				case 4: sb.append(idx == 0 ? 1 : 0).append("\n"); break;
				case 5: sb.append(idx > 0 ? deque[idx-1] : -1).append("\n"); break;
			}
		}
		System.out.print(sb);
	}
}