package q43_동적계획법4.a_2169;
/*
문제
N개의 도시와 그 도시를 연결하는 N-1개의 도로로 이루어진 도로 네트워크가 있다. 

모든 도시의 쌍에는 그 도시를 연결하는 유일한 경로가 있고, 각 도로의 길이는 입력으로 주어진다.

총 K개의 도시 쌍이 주어진다. 이때, 두 도시를 연결하는 경로 상에서 가장 짧은 도로의 길이와 가장 긴 도로의 길이를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (2 ≤ N ≤ 100,000)

다음 N-1개 줄에는 도로를 나타내는 세 정수 A, B, C가 주어진다. A와 B사이에 길이가 C인 도로가 있다는 뜻이다. 도로의 길이는 1,000,000보다 작거나 같은 양의 정수이다.

다음 줄에는 K가 주어진다. (1 ≤ K ≤ 100,000)

다음 K개 줄에는 서로 다른 두 자연수 D와 E가 주어진다. D와 E를 연결하는 경로에서 가장 짧은 도로의 길이와 가장 긴 도로의 길이를 구해서 출력하면 된다.

출력
총 K개 줄에 D와 E를 연결하는 경로에서 가장 짧은 도로의 길이와 가장 긴 도로의 길이를 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception {
		Reader r = new Reader();
		int N = r.in(), M = r.in(), map[][] = new int[N+1][M+1], dp[][] = new int[N+1][M+1];
		for(int i = 1; i <= N; i++) for(int j = 1; j <= M; j++) map[i][j] = r.in();
		
		dp[1][1] = map[1][1];
		for(int i = 2; i <= M; i++) dp[1][i] = dp[1][i-1] + map[1][i];
		for(int i = 2; i <= N; i++) {
			int[] R = new int[M+2], L = new int[M+2];
			R[0] = dp[i-1][1]; L[M+1] = dp[i-1][M];
			for(int j = 1; j <= M; j++) R[j] = Math.max(R[j-1], dp[i-1][j]) + map[i][j];
			for(int j = M; j >= 1; j--) L[j] = Math.max(L[j+1], dp[i-1][j]) + map[i][j];
			for(int j = 1; j <= M; j++) dp[i][j] = Math.max(R[j], L[j]);
		}
		System.out.println(dp[N][M]);
	}
}
class Reader {
	BufferedReader br; StringTokenizer st;
    Reader(){br=new BufferedReader(new InputStreamReader(System.in));}
    String ns(){if(st==null||!st.hasMoreTokens())try{st=new StringTokenizer(br.readLine());}catch(IOException e){}return st.nextToken();}
    int in(){return Integer.parseInt(ns());}
}