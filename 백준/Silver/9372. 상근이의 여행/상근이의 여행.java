import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
			for(int i = 0; i < M; i++) br.readLine();
			sb.append(N-1).append("\n");
		}
		System.out.print(sb);
	}
}