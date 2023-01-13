import java.io.*;
import java.util.*;

class Node{
    int s, e, w;
    public Node(int s, int e, int w){
        this.s = s;
        this.e = e;
        this.w = w;
    }
}
public class Main {
    static final int INF = 1000000000;
    static int N, M;
    static long[] dp;
    static Node[] A;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new Node[M];
        dp = new long[N+1];
        Arrays.fill(dp, INF);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            A[i] = new Node(
        		Integer.parseInt(st.nextToken()), 
        		Integer.parseInt(st.nextToken()), 
        		Integer.parseInt(st.nextToken()));
        }
        if(bmf()) 
        	for(int i = 2; i <= N; i++) 
        		sb.append(dp[i] == INF ? "-1" : dp[i]).append("\n");
        else sb.append("-1\n");
        System.out.print(sb);
    }
    private static boolean bmf() {
        dp[1] = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                Node n = A[j];
                if(dp[n.s] != INF && dp[n.e] > dp[n.s] + n.w) {
                	if (i < N-1) dp[n.e] = dp[n.s] + n.w;
                	else return false;
                }
            }
        }
        return true;
    }
}