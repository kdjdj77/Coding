package q30_동적계획법과최단거리역추적.a01_12852;
/*
문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 
연산을 사용하는 횟수의 최솟값을 출력하시오.

입력
첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 자연수 N이 주어진다.

출력
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.

둘째 줄에는 N을 1로 만드는 방법에 포함되어 있는 수를 공백으로 구분해서 순서대로 출력한다. 
정답이 여러 가지인 경우에는 아무거나 출력한다.
*/

import java.io.*;
import java.util.*;
 
public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		ArrayList<Integer> path = new ArrayList<>();
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		while(!q.isEmpty()) {
			int cur = q.poll();
			if (cur == N) break; 
			for(int a : new int[] {cur+1, cur*2, cur*3})
				if (a <= N && dp[a] == 0) { dp[a] = cur; q.add(a); }
		}
		while(N != 0) { path.add(N); N = dp[N]; }
		sb.append(path.size()-1).append("\n");
		for(int a : path) sb.append(a).append(" ");
		System.out.print(sb);
	}
}