import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
        int N = Integer.parseInt(br.readLine());
        int log = 19;
        int[][] dp = new int[log+1][N+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) dp[0][i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= log; i++)
            for (int j = 1; j <= N; j++)
                dp[i][j] = dp[i-1][dp[i-1][j]];

        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            log = 19;
            while(log-- > 0) {
                int cur = (1 << log);
                if (n >= cur) {
                    x = dp[log][x];
                    n -= cur;
                    if (n == 0) break;
                }
            }
            sb.append(x).append("\n");
        }
        System.out.print(sb);
    }
}