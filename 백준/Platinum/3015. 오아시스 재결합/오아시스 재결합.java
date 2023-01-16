import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> s = new Stack<>();
		
		long cnt = 0;
		for (int i = 0; i < N; i++) {
			int h = Integer.parseInt(br.readLine());
			int[] me = {h, 1};

			while (!s.empty() && s.peek()[0] <= h) {
				int[] tmp = s.pop();
				cnt += tmp[1];
				if (tmp[0] == h) me[1] += tmp[1];
			}
			if (!s.empty()) cnt++;
			s.push(me);
		}
		System.out.print(cnt);
	}
}