import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<int[]> dq = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) dq.add(new int[] {i+1, Integer.parseInt(st.nextToken())});
        while(dq.size() > 1) {
            int cur[] = dq.poll(), m = cur[1];
            sb.append(cur[0]).append(" ");
            if (m > 0) while(--m > 0) dq.add(dq.poll());
            else while(m++ < 0) dq.addFirst(dq.pollLast());
        }
        System.out.print(sb.append(dq.poll()[0]));
    }
}