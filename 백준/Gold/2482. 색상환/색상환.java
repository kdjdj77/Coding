import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int M = 1000000003;

        int[][] dp = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) { dp[i][0] = 1; dp[i][1] = i; }
        
        for(int i = 3; i <= N; i++)
            for(int j = 2; j <= i/2+1; j++)
                dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % M;
        
        System.out.print((dp[N-3][K-1] + dp[N-1][K]) % M);
    }
}