package q00_ETC.rank5pp.a16566;
/*
문제
철수와 민수는 카드 게임을 즐겨한다. 이 카드 게임의 규칙은 다음과 같다.

N개의 빨간색 카드가 있다. 각각의 카드는 순서대로 1부터 N까지 번호가 매겨져 있다. 이 중에서 M개의 카드를 고른다.
N개의 파란색 카드가 있다. 각각의 카드는 순서대로 1부터 N까지 번호가 매겨져 있다. 이 중에서 빨간색에서 고른 번호와 같은 파란색 카드 M개를 고른다.
철수는 빨간색 카드를 가지고 민수는 파란색 카드를 가진다.
철수와 민수는 고른 카드 중에 1장을 뒤집어진 상태로 낸다. 그리고 카드를 다시 뒤집어서 번호가 큰 사람이 이긴다. 이 동작을 K번 해서 더 많이 이긴 사람이 최종적으로 승리한다. 한 번 낸 카드는 반드시 버려야 한다.
철수는 뛰어난 마술사이기 때문에 본인이 낼 카드를 마음대로 조작할 수 있다. 즉, 카드를 버리고 민수 몰래 다시 들고 온다거나 민수한테 없는 카드를 내기도 한다.

민수는 뛰어난 심리학자이기 때문에 철수가 낼 카드를 알아낼 수 있다. 그래서 민수는 철수가 낼 카드보다 큰 카드가 있다면 그 카드들 중 가장 작은 카드를 내기로 했다.

K번 동안 철수가 낼 카드가 입력으로 주어진다. 그렇다면 민수가 어떤 카드를 낼지 출력하라. 단, 민수가 카드를 내지 못하는 경우는 없다고 가정한다.

입력
첫째 줄에 세 개의 자연수 N, M, K가 주어진다. (1 ≤ M ≤ N ≤ 4,000,000, 1 ≤ K ≤ min(M, 10,000))

다음 줄에 카드의 번호를 나타내는 M개의 자연수가 주어진다. 각각의 수들은 1 이상이고 N 이하이며 서로 다르다.

다음 줄에 K개의 자연수가 주어진다. i번째 수는 철수가 i번째로 내는 카드의 번호이다. 철수가 내는 카드 역시 1 이상 N 이하이다.

출력
K줄에 걸쳐서 수를 출력한다. i번째 줄에는 민수가 i번째로 낼 카드의 번호가 출력되어야 한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = in(), M = in(), K = in();
		int[] card = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(card);
		st = new StringTokenizer(br.readLine());
		while(K-- > 0) {
			int cur = in();
		}
	}
	private static int in() {return Integer.parseInt(st.nextToken());}
}