import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), dp[][] = new int[n+1][10];
        String a = br.readLine(), b = br.readLine();
        while(n-- > 0) for(int i = 0; i < 10; i++) {
            int s = (b.charAt(n)-'0'+10-((a.charAt(n)-'0'+i)%10))%10;
            dp[n][i] = Math.min(dp[n+1][(s+i)%10]+s, dp[n+1][i]+10-s);
        }
        System.out.print(dp[0][0]);
    }
}