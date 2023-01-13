import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> A = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        dp = new int[N+1];
        for(int i = 0; i <= N; i++) A.add(new ArrayList<>());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A.get(x).add(y);
            A.get(y).add(x);
        }

        for(int i = 1; i <= N; i++) Collections.sort(A.get(i), Collections.reverseOrder());
        bfs(s);

        for(int i = 1; i <= N; i++) sb.append(dp[i]).append("\n");
        System.out.println(sb);
    }

    static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        int cnt = 1;

        q.offer(s);
        dp[s] = cnt++;

        while(!q.isEmpty()){
            int a = q.poll();
            for(int i : A.get(a)) {
                if(dp[i] == 0) {
	                q.offer(i);
	                dp[i] = cnt++;
                }
            }
        }
    }
}