import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 12345678;
    static int house[][], dp[][], N;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        house = new int[N][3];
        dp = new int[N][3];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++) house[i][j] = Integer.parseInt(st.nextToken()); 
        }
        int res = INF;
        for(int i = 0; i < 3; i++) res = Math.min(res, res(i));
        System.out.println(res);        
    }
    static int res(int s) {
    	int res = INF;
    	
    	for(int i = 0; i < 3; i++) dp[0][i] = INF;
    	dp[0][s] = house[0][s];
    	
        for(int i = 1; i < N; i++) {
        	for(int j = 0; j < 3; j++) {
        		dp[i][j] = Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + house[i][j];
        		if (i == N-1) if(s != j) res = Math.min(res, dp[N-1][j]);
        	}
    	}
        return res;
    }
}