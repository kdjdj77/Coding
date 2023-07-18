package q00_ETC.rank6.a7578;
/*
문제
지민이는 전체 페이지의문제
어떤 공장에는 2N개의 기계가 2열에 걸쳐 N개씩 배치되어 있다. 이 2개의 열을 각각 A열과 B 열이라고 부른다. A열에 있는 N개의 기계는 각각이 B열에 있는 N개의 기계와 하나씩 짝을 이루어 케이블로 연결되어 있다. 즉, A열의 임의의 기계는 B열의 유일한 기계와 케이블로 연결되어 있고, B열의 임의의 기계는 A열의 유일한 기계와 케이블로 연결되어 있다

또한, 각 기계에는 식별번호가 붙어있으며, 짝이 맺어진 기계끼리는 같은 식별번호가 붙어있다. 즉, 각 열에 있는 N개의 기계끼리는 서로 다른 식별번호를 가지고 있으며, 반대쪽 열에 있는 같은 식별번호를 가진 기계와 케이블로 이어져 있다.

공장 작업의 효율성을 위해 기계들은 짝을 맺은 순서대로 배치되지 않으며, 필요에 따라 각 열의 기계들의 순서를 바꾼 바람에 케이블은 마구 엉켜있는 상태이다. 이렇게 엉켜버린 케이블은 잦은 고장의 원인이 되기 때문에, 기계의 위치를 바꾸지 않은 상태에서 케이블을 두 기계를 잇는 직선의 형태로 만들기로 했다.



예를 들어, 위의 그림과 같이 N = 5이고, A열에 위치한 기계의 식별번호가 순서대로 132, 392, 311, 351, 231이고 B열에 위치한 기계의 식별번호가 순서대로 392, 351, 132, 311, 231이라면 케이블들의 교차 횟수 혹은 서로 교차하는 케이블 쌍의 개수는 3이 된다.

정수 N과 A열에 위치한 기계, B열에 위치한 기계의 식별번호가 각각 순서대로 주어질 때에 서로 교차하는 케이블 쌍의 개수를 정확하게 세어 출력하는 프로그램을 작성하시오.

입력
입력은 세 줄로 이루어져 있다. 첫 줄에는 정수 N이 주어지며, 두 번째 줄에는 A열에 위치한 N개 기계의 서로 다른 식별번호가 순서대로 공백문자로 구분되어 주어진다. 세 번째 줄에는 B열에 위치한 N개의 기계의 식별번호가 순서대로 공백문자로 구분되어 주어진다.

단, 1 ≤ N ≤ 500,000이며, 기계의 식별번호는 모두 0 이상 1,000,000 이하의 정수로 주어진다.

출력
여러분은 읽어 들인 2N개의 기계의 배치로부터 서로 교차하는 케이블 쌍의 개수를 정수 형태로 한 줄에 출력해야 한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	static long[] tree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), A[] = new int[N+1];
		Map<Integer, Integer> B = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) B.put(Integer.parseInt(st.nextToken()), i);

		tree = new long[N<<2];
		long res = 0;
		for(int i = 1; i <= N; i++) {
			int v = B.get(A[i]);
			res += calc(1, N, 1, v+1, N);
			update(1, N, 1, v, 1);
		}
		System.out.print(res);
	}
	static long calc(int s, int e, int n, int l, int r) {
		if (e < l || r < s) return 0;
		if (l <= s && e <= r) return tree[n];
		int m = s+e >> 1;
		return calc(s, m, n<<1, l, r) + calc(m+1, e, (n<<1)+1, l, r);
	}
	static void update(int s, int e, int n, int idx, int dif) {
		if (idx < s || idx > e) return;
		tree[n] += dif;
		if (e <= s) return;
		int m = s+e >> 1;
		update(s, m, n<<1, idx, dif);
		update(m+1, e, (n<<1)+1, idx, dif);
	}
}