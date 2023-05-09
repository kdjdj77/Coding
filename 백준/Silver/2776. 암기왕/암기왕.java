import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			Set<Integer> set = new HashSet<>();
			
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while(N-- > 0) set.add(Integer.parseInt(st.nextToken()));
			
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while(N-- > 0) {
				int num = Integer.parseInt(st.nextToken());
				sb.append(set.contains(num) ? 1 : 0).append("\n");
			}
		}
		System.out.print(sb);
    }
}