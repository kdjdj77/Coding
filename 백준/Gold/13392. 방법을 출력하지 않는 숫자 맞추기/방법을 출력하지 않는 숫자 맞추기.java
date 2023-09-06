import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), dp[][] = new int[N+1][10];
        int[] A = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        for(int i = 0; i <= N; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        for(int i = 0; i < 10; i++) dp[0][i] = i;
        for(int i = 0; i < N; i++) for(int j = 0; j < 10; j++) {
            int r = (B[i]-A[i]-j+20)%10, l = 10-r, k = (r+j)%10;
            dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+l);
            dp[i+1][k] = Math.min(dp[i+1][k], dp[i][j]+r);
        }
        System.out.print(Arrays.stream(dp[N]).min().getAsInt());
    }
}