package q30_동적계획법과최단거리역추적.a06_13913;
/*
문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 
동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 
만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
첫째 줄에 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

둘째 줄에 어떻게 이동해야 하는지 공백으로 구분해 출력한다.
*/

import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int L = 100001;
		int[] A = new int[L], dp = new int[L];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(N); dp[N] = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			if (cur == K) break;
			for(int a : new int[] {cur+1, cur-1, cur*2}) {
				if (a < 0 || a >= L || A[a] != 0) continue;
				A[a] += A[cur] + 1;
				dp[a] = cur; q.add(a);
			}
		}
		sb.append(A[K]).append("\n");
		
		Stack<Integer> s = new Stack<>();
		s.add(K);
		while(K != N) s.add(K = dp[K]);
		while(!s.isEmpty()) sb.append(s.pop()).append(" ");
		System.out.print(sb);
	}
}