import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		boolean[] dp = new boolean[21];
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			switch(s) {
				case "all": Arrays.fill(dp, true); break;
				case "empty": dp = new boolean[21]; break;
				default:
					int b = Integer.parseInt(st.nextToken());
					switch(s) {
						case "add": dp[b] = true; break;
						case "remove": dp[b] = false; break;
						case "check": sb.append(dp[b] ? "1\n" : "0\n"); break;
						case "toggle": dp[b] = !dp[b]; break;
					}
			}			
		}
		System.out.print(sb);
	}
}