package q36_동적계획법3.a05_17404;
/*
문제
RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

1번 집의 색은 2번, N번 집의 색과 같지 않아야 한다.
N번 집의 색은 N-1번, 1번 집의 색과 같지 않아야 한다.
i(2 ≤ i ≤ N-1)번 집의 색은 i-1, i+1번 집의 색과 같지 않아야 한다.
입력
첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
*/

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