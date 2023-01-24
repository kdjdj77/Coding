package q35_기하2.a07_2162;
/*
문제
N개의 선분들이 2차원 평면상에 주어져 있다. 선분은 양 끝점의 x, y 좌표로 표현이 된다.

두 선분이 서로 만나는 경우에, 두 선분은 같은 그룹에 속한다고 정의하며, 그룹의 크기는 그 그룹에 속한 선분의 개수로 정의한다. 두 선분이 만난다는 것은 선분의 끝점을 스치듯이 만나는 경우도 포함하는 것으로 한다.

N개의 선분들이 주어졌을 때, 이 선분들은 총 몇 개의 그룹으로 되어 있을까? 또, 가장 크기가 큰 그룹에 속한 선분의 개수는 몇 개일까? 이 두 가지를 구하는 프로그램을 작성해 보자.

입력
첫째 줄에 N(1 ≤ N ≤ 3,000)이 주어진다. 둘째 줄부터 N+1번째 줄에는 양 끝점의 좌표가 x1, y1, x2, y2의 순서로 주어진다. 각 좌표의 절댓값은 5,000을 넘지 않으며, 입력되는 좌표 사이에는 빈칸이 하나 있다.

출력
첫째 줄에 그룹의 수를, 둘째 줄에 가장 크기가 큰 그룹에 속한 선분의 개수를 출력한다.
*/

import java.io.*;
import java.util.*;

class Dot {
	long x, y;
	public Dot(long x, long y) {
		this.x = x;
		this.y = y;
	}
}
class Line {
	Dot a, b;
	public Line(Dot a, Dot b) {
		this.a = a;
		this.b = b;
	}
}
public class Main {
	static int[] A;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Line[] lines = new Line[N];
		A = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Dot a = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Dot b = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			lines[i] = new Line(a, b);
			A[i] = i;
		}
		for(int i = 0; i < N-1; i++)
			for(int j = i+1; j < N; j++)
				if (isMeet(lines[i], lines[j])) union(i, j);
		
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for(int i = 0; i < N; i++) {
			int tmp = map.getOrDefault(A[i] = root(A[i]), 0) + 1;
			if (tmp > max) max = tmp;
			map.put(A[i], tmp);
		}
		sb.append(map.size()).append("\n").append(max);
		System.out.print(sb);
	}
	static boolean isMeet(Line A, Line B) {
		boolean res = false;
		int b1 = ccw(A.a, A.b, B.a), b2 = ccw(A.a, A.b, B.b);
		int a1 = ccw(B.a, B.b, A.a), a2 = ccw(B.a, B.b, A.b);
		
		if (b1 == 0 && b2 == 0 & a1 == 0 & a2 == 0) res = overlap(A, B);
		else res = b1 * b2 <= 0 && a1 * a2 <= 0;
		return res;
	}
	static int ccw(Dot a, Dot b, Dot c) {
		long l = a.x*b.y + b.x*c.y + c.x*a.y - a.y*b.x - b.y*c.x - c.y*a.x;
		if (l != 0) return l > 0 ? 1 : -1;
		return 0;
	}
	static boolean overlap(Line L1, Line L2) {
        long[] sA, sB;
        if (L1.a.x == L1.b.x) {
        	sA = new long[] {L1.a.y, L1.b.y};
        	sB = new long[] {L2.a.y, L2.b.y};
        } else {
        	sA = new long[] {L1.a.x, L1.b.x};
        	sB = new long[] {L2.a.x, L2.b.x};
        }
        Arrays.sort(sA); Arrays.sort(sB);
        if (sA[0]<=sB[1] && sB[0]<=sA[1]) return true;
        else return false;
    }
	static int root(int x) {
        if(x == A[x]) return x;
        return A[x] = root(A[x]);
	}
    static void union(int x, int y) {
        x = root(x); y = root(y);
        if (x == y) return;
        if (x < y) A[y] = x;
        else A[x] = y;
    }
}