package q00_ETC.rank5pp.a2887;
/*
문제
때는 2040년, 이민혁은 우주에 자신만의 왕국을 만들었다. 왕국은 N개의 행성으로 이루어져 있다. 민혁이는 이 행성을 효율적으로 지배하기 위해서 행성을 연결하는 터널을 만들려고 한다.

행성은 3차원 좌표위의 한 점으로 생각하면 된다. 두 행성 A(xA, yA, zA)와 B(xB, yB, zB)를 터널로 연결할 때 드는 비용은 min(|xA-xB|, |yA-yB|, |zA-zB|)이다.

민혁이는 터널을 총 N-1개 건설해서 모든 행성이 서로 연결되게 하려고 한다. 이때, 모든 행성을 터널로 연결하는데 필요한 최소 비용을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 행성의 개수 N이 주어진다. (1 ≤ N ≤ 100,000) 다음 N개 줄에는 각 행성의 x, y, z좌표가 주어진다. 좌표는 -109보다 크거나 같고, 109보다 작거나 같은 정수이다. 한 위치에 행성이 두 개 이상 있는 경우는 없다. 

출력
첫째 줄에 모든 행성을 터널로 연결하는데 필요한 최소 비용을 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]), pqs[] = new PriorityQueue[3];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, res = 0, cnt = 0, root[];
	public static void main(String[] args) throws IOException{
		root = new int[N = Integer.parseInt(br.readLine())];
		for(int i = 0; i < 3; i++) pqs[i] = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		for(int i = 0; i < N; root[i] = i++) for(int j = st(0); j < 3; j++) pqs[j].add(new int[] {i, in()});
		for(int i = 0; i < 3; i++) for(int j = 0; j < N-1; j++) {
			int[] cur = pqs[i].poll(), next = pqs[i].peek();
			pq.add(new int[] {cur[0], next[0], Math.abs(cur[1]-next[1])});
		}
		while(!pq.isEmpty()) {
			int edge[] = pq.poll(), s = root(edge[0]), e = root(edge[1]);
			if (s != e) {res += edge[2]; root[e] = s; if (++cnt == N-1) break;}
		}
		System.out.println(res);
	}
	static int st(int n) {try {st = new StringTokenizer(br.readLine());} catch (IOException e) {} return n;}
	static int in() {return Integer.parseInt(st.nextToken());}
	static int root(int n) {return root[n] == n ? n : (root[n] = root(root[n]));}
}
