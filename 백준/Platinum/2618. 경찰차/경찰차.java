import java.io.*;
import java.util.*;

public class Main {
    public static int[][] inc, dp;
    public static int N, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());

        inc = new int[W+1][2];
        dp = new int[W+1][W+1];
        for(int x = 1; x <= W; x++) {
            st = new StringTokenizer(br.readLine());
            inc[x][0] = Integer.parseInt(st.nextToken());
            inc[x][1] = Integer.parseInt(st.nextToken());
        }
        sb.append(res(1, 0, 0)).append("\n");
        
        int p1 = 0, p2 = 0;
        for(int nth = 1; nth <= W; nth++) {
        	int p1m = dist(1, p1, nth);
            if (dp[p1][p2] == dp[nth][p2] + p1m) { p1 = nth; sb.append("1\n"); }
            else { p2 = nth; sb.append("2\n"); }
        }
        System.out.print(sb);
    }
    public static int res(int nth, int p1, int p2) {
        if (nth > W) return 0;
        if (dp[p1][p2]!=0) return dp[p1][p2];
        
        int d1 = res(nth+1, nth, p2) + dist(1, p1, nth);
        int d2 = res(nth+1, p1, nth) + dist(2, p2, nth);
        
        return dp[p1][p2] = d1 < d2 ? d1 : d2;
    }
    public static int dist(int who, int s, int e) {
        int x1 = inc[s][0], x2 = inc[e][0];
        int y1 = inc[s][1], y2 = inc[e][1];
        if(s == 0) x1 = y1 = who == 1 ? 1 : N;
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}