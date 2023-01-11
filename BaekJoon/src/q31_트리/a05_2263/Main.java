package q31_트리.a05_2263;
/*
문제
n개의 정점을 갖는 이진 트리의 정점에 1부터 n까지의 번호가 중복 없이 매겨져 있다. 
이와 같은 이진 트리의 인오더와 포스트오더가 주어졌을 때, 프리오더를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 n(1 ≤ n ≤ 100,000)이 주어진다. 다음 줄에는 인오더를 나타내는 n개의 자연수가 주어지고, 
그 다음 줄에는 같은 식으로 포스트오더가 주어진다.

출력
첫째 줄에 프리오더를 출력한다.
*/

import java.io.*;
import java.util.*;
 
public class Main {
	static int[] IN, POST, PRE;
	static int idx;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		IN = new int[N];
		POST = new int[N];
		PRE = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) IN[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) POST[i] = Integer.parseInt(st.nextToken());
		
		setPre(0, N-1, 0, N-1);
		for(int i = 0; i < N; i++) sb.append(PRE[i]).append(" ");
		
		System.out.print(sb);
	}
	public static void setPre(int in1, int in2, int post1, int post2) {
		if (in1 <= in2 && post1 <= post2) {
			PRE[idx++] = POST[post2];

			int rootIdx = in1;
			for (int i = in1; i <= in2; i++) {
				if (IN[i] == POST[post2]) { rootIdx = i; break; }
			}
			setPre(in1, rootIdx - 1, post1, post1 + rootIdx - in1 - 1);
			setPre(rootIdx + 1, in2, post1 + rootIdx - in1, post2 - 1);
		}
	}
}