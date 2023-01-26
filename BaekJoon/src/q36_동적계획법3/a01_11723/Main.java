package q36_동적계획법3.a01_11723;
/*
문제
비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.

add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
all: S를 {1, 2, ..., 20} 으로 바꾼다.
empty: S를 공집합으로 바꾼다. 
입력
첫째 줄에 수행해야 하는 연산의 수 M (1 ≤ M ≤ 3,000,000)이 주어진다.

둘째 줄부터 M개의 줄에 수행해야 하는 연산이 한 줄에 하나씩 주어진다.

출력
check 연산이 주어질때마다, 결과를 출력한다.
*/

import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int dp = 0;
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			if (s.equals("all")) { dp = (1 << 21) - 1; continue;}
			if (s.equals("empty")) { dp = 0; continue;}
			
			int b = Integer.parseInt(st.nextToken());
			if (s.equals("add")) dp |= 1 << b;
			else if (s.equals("remove")) dp &= ~(1 << b);
			else if (s.equals("check")) sb.append((dp & (1 << b)) == (1 << b) ? "1\n" : "0\n");
			else if (s.equals("toggle")) dp ^= (1 << b);
		}
		System.out.print(sb);
	}
}