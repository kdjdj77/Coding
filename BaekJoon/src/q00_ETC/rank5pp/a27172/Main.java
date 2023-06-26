package q00_ETC.rank5pp.a27172;
/*
문제
《보드게임컵》을 준비하다 지친 은하는 보드게임컵 참가자들을 경기장에 몰아넣고 결투를 시키는 게임 《수 나누기 게임》을 만들었습니다.

《수 나누기 게임》의 규칙은 다음과 같습니다.

게임을 시작하기 전 각 플레이어는 
$1$부터 
$1\,000\,000$ 사이의 수가 적힌 서로 다른 카드를 잘 섞은 뒤 한 장씩 나눠 가집니다.
매 턴마다 플레이어는 다른 플레이어와 한 번씩 결투를 합니다.
결투는 서로의 카드를 보여주는 방식으로 진행되며, 플레이어의 카드에 적힌 수로 다른 플레이어의 카드에 적힌 수를 나눴을 때, 나머지가 
$0$이면 승리합니다. 플레이어의 카드에 적힌 수가 다른 플레이어의 카드에 적힌 수로 나누어 떨어지면 패배합니다. 둘 다 아니라면 무승부입니다.
승리한 플레이어는 
$1$점을 획득하고, 패배한 플레이어는 
$1$점을 잃습니다. 무승부인 경우 점수의 변화가 없습니다.
본인을 제외한 다른 모든 플레이어와 정확히 한 번씩 결투를 하고 나면 게임이 종료됩니다.
《수 나누기 게임》의 결과를 가지고 한별이와 내기를 하던 은하는 게임이 종료되기 전에 모든 플레이어의 점수를 미리 알 수 있을지 궁금해졌습니다. 은하를 위해 각 플레이어가 가지고 있는 카드에 적힌 수가 주어졌을 때, 게임이 종료된 후의 모든 플레이어의 점수를 구해주세요.

입력
첫 번째 줄에 플레이어의 수 
$N$이 주어집니다.

두 번째 줄에 첫 번째 플레이어부터 
$N$번째 플레이어까지 각 플레이어가 가지고 있는 카드에 적힌 정수 
$x_{1}$, 
$\cdots$, 
$x_{N}$이 공백으로 구분되어 주어집니다.

출력
첫 번째 플레이어부터 
$N$번째 플레이어까지 게임이 종료됐을 때의 각 플레이어의 점수를 공백으로 구분하여 출력해주세요.
*/

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()), X[] = new int[N], INF = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) INF = Math.max(INF, X[i] = Integer.parseInt(st.nextToken()));
		
		int[] P = new int[N+1], pos = new int[INF+1];
		for(int i = 0; i < N; i++) pos[X[i]] = i+1;

		for(int m : X) for(int j = m*2; j <= INF; j += m) if (pos[j] != 0) {P[pos[j]]--; P[pos[m]]++;}
		for(int i = 1; i <= N; i++) sb.append(P[i]).append(" ");
		System.out.print(sb);
	}
}