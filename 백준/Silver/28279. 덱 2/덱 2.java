import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(Integer.parseInt(st.nextToken())) {
			case 1: dq.addFirst(Integer.parseInt(st.nextToken())); break;
			case 2: dq.addLast(Integer.parseInt(st.nextToken())); break;
			case 3: sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append("\n"); break;
			case 4: sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append("\n"); break;
			case 5: sb.append(dq.size()).append("\n"); break;
			case 6: sb.append(dq.isEmpty() ? 1 : 0).append("\n"); break;
			case 7: sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append("\n"); break;
			case 8: sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append("\n"); break;
			}
		}
		System.out.print(sb);
	}
}