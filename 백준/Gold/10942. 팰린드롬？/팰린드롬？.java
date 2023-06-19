import java.io.*;
import java.util.*;

public class Main {
	static int N, arr[];
	static boolean[][] dp, visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine())+1;
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        dp = new boolean[N][N];
        visit = new boolean[N][N];
        for(int s = 1; s < N; s++) for(int e = s; e < N; e++) set(s, e);
        int M = Integer.parseInt(br.readLine());
        while(M-- > 0) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
        	sb.append(dp[s][e] ? 1 : 0).append("\n");
        }
        System.out.print(sb);
    }
    static void set(int s, int e) {
		if (visit[s][e]) return;
		if (isPal(s, e)) while(s <= e) {visit[s][e] = true; dp[s++][e--] = true;}
		else dp[s][e] = false;
    }
    static boolean isPal(int s, int e) {
    	while(s <= e) if (arr[s++] != arr[e--]) return false;
    	return true;
    }
}