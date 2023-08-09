package q20_스택.a_28278;
/*
문제
정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 다섯 가지이다.

1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
3: 스택에 들어있는 정수의 개수를 출력한다.
4: 스택이 비어있으면 1, 아니면 0을 출력한다.
5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
입력
첫째 줄에 명령의 수 N이 주어진다. (1 ≤ N ≤ 1,000,000)

둘째 줄부터 N개 줄에 명령이 하나씩 주어진다.

출력을 요구하는 명령은 하나 이상 주어진다.

출력
출력을 요구하는 명령이 주어질 때마다 명령의 결과를 한 줄에 하나씩 출력한다.
*/


import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()), idx = 0, dq[] = new int[2];
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(Integer.parseInt(st.nextToken())) {
				case 1:
					if (idx >= dq.length) dq = Arrays.copyOf(dq, dq.length<<1);
					dq[idx++] = Integer.parseInt(st.nextToken());
					break;
				case 2: sb.append(idx > 0 ? dq[--idx] : -1).append("\n"); break;
				case 3: sb.append(idx).append("\n"); break;
				case 4: sb.append(idx == 0 ? 1 : 0).append("\n"); break;
				case 5: sb.append(idx > 0 ? dq[idx-1] : -1).append("\n"); break;
			}
		}
		System.out.print(sb);
	}
}
