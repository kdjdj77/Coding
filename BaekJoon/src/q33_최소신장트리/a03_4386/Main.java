package q33_최소신장트리.a03_4386;
/*
문제
도현이는 우주의 신이다. 이제 도현이는 아무렇게나 널브러져 있는 n개의 별들을 이어서 별자리를 하나 만들 것이다. 별자리의 조건은 다음과 같다.

별자리를 이루는 선은 서로 다른 두 별을 일직선으로 이은 형태이다.
모든 별들은 별자리 위의 선을 통해 서로 직/간접적으로 이어져 있어야 한다.
별들이 2차원 평면 위에 놓여 있다. 선을 하나 이을 때마다 두 별 사이의 거리만큼의 비용이 든다고 할 때, 별자리를 만드는 최소 비용을 구하시오.

입력
첫째 줄에 별의 개수 n이 주어진다. (1 ≤ n ≤ 100)

둘째 줄부터 n개의 줄에 걸쳐 각 별의 x, y좌표가 실수 형태로 주어지며, 최대 소수점 둘째자리까지 주어진다. 좌표는 1000을 넘지 않는 양의 실수이다.

출력
첫째 줄에 정답을 출력한다. 절대/상대 오차는 10-2까지 허용한다.
*/

import java.io.*;
import java.util.*;

class Star {
	Double x, y;
	public Star(Double x, Double y) {
		this.x = x;
		this.y = y;
	}
}
class Node implements Comparable<Node> {
	int l, r;
	Double w;
	public Node(int l, int r, Double w) {
		this.l = l;
		this.r = r;
		this.w = w;
	}
	@Override
	public int compareTo(Node o) {
		return this.w > o.w ? 1 : -1;
	}
}
public class Main {
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		Star[] stars = new Star[N];
		PriorityQueue<Node> path = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Double x = Double.parseDouble(st.nextToken());
			Double y = Double.parseDouble(st.nextToken());
			stars[i] = new Star(x, y);
		}
		
		A = new int[N];
		for(int i = 1; i < N; i++) A[i] = i;
		
		for(int i = 0; i < N-1; i++)
			for(int j = i+1; j < N; j++) 
				path.add(new Node(i, j, dist(stars[i], stars[j])));
		
		float res = 0f;
		while(!path.isEmpty()) {
			Node n = path.poll();
			if (!isSameRoot(n.l, n.r)) {
				union(n.l, n.r);
				res += n.w;
			}
		}
		System.out.print(res);
	}
	public static int root(int x) {
        if(x == A[x]) return x;
        return A[x] = root(A[x]);
	}
    public static void union(int x, int y) {
        x = root(x); y = root(y);
        if (x == y) return;
        if (x < y) A[y] = x;
        else A[x] = y;
    }
    public static boolean isSameRoot(int x, int y) {
        return root(x) == root(y);
    }
    public static Double dist(Star a, Star b) {
    	Double dx = a.x - b.x;
    	Double dy = a.y - b.y;
    	return Math.sqrt(dx*dx + dy*dy);
    }
}