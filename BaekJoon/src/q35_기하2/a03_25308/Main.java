package q35_기하2.a03_25308;
/*
문제
게임 캐릭터의 능력치를 한 눈에 보기 좋게 나타내는 방법으로 방사형 그래프가 있다. 캐릭터는 8개의 능력치를 갖고 있고 각 능력치를 
$a_1, a_2, \cdots, a_8$이라고 하면, 그래프는 팔각형 형태이고 
$k$번째 꼭짓점은 원점을 기준으로 
$45\times k$도 방향으로 
$a_k$만큼 떨어져 있다.



방사형 그래프를 사용하면 능력치가 얼마나 고르게 분포되어 있는지 쉽게 알 수 있다. 만약 모든 능력치가 동일하다면 정다각형 형태가 되고, 한 능력치가 다른 능력치에 비해 현저히 낮으면 오목 다각형이 된다. 많은 사람들은 방사형 그래프를 볼록 다각형, 즉 모든 내각이 
$180°$ 이하인 다각형으로 만들어 자신의 약점을 없애기 위해 노력한다.

시루는 자신의 그래프를 볼록 다각형으로 바꾸고 싶지만, 능력치를 올리는 것은 매우 귀찮기 때문에 한 가지 꼼수를 생각해냈다. 바로 능력치를 나열하는 순서를 바꾸는 것이다. 예를 들어, 
$\lbrace 6,7,7,8,9,10,11,13 \rbrace$ 순서대로 나열하면 오목 다각형이 되지만, 순서를 바꿔 
$\lbrace 7,6,7,8,9,10,11,13 \rbrace$ 순서대로 나열하면 볼록 다각형이 된다.



능력치를 나열하는 순서에 따라 오목 다각형이 될 수도, 볼록 다각형이 될 수도 있기 때문에, 시루는 능력치를 잘 배열해서 볼록 다각형이 되는 경우의 수가 궁금해졌다. 볼록 다각형을 만드는 경우의 수를 구해보자.

입력
첫째 줄에 8개의 능력치를 나타내는 정수 
$a_1, a_2, \cdots , a_8$가 공백으로 구분되어 주어진다. (
$1 \leq a_i \leq 10^4$)

출력
8개의 능력치를 잘 배열해서 방사형 그래프를 볼록 다각형으로 만드는 경우의 수를 출력한다.
*/

import java.io.*;
import java.util.*;
 
public class Main {
	static final double r2 = Math.sqrt(2);
	static int res = 0, stats[] = new int[8];
	static boolean[] visit = new boolean[8];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 8; i++) stats[i] = Integer.parseInt(st.nextToken());
		setRes(1, new int[] {stats[0],0,0,0,0,0,0,0});
		System.out.print(res*8);
	}
	public static boolean ccw(int a1, int a2, int a3) {
		double d = (r2*a1*a3) / (a3 + a1);
		return a2 > d;
	}
	public static boolean isConvex(int[] a) {
		for(int i = 0; i < 8; i++)
			if (!ccw(a[i], a[(i+1)%8], a[(i+2)%8]))
				return false;
		return true;
	}
	public static void setRes(int depth, int[] tmp) {
		if (depth == 8) if (isConvex(tmp)) res++;
		for(int i = 1; i < 8; i++) {
			if (visit[i]) continue;
			visit[i] = true;
			tmp[depth] = stats[i];
			setRes(depth+1, tmp);
			visit[i] = false;
		}
	}
}