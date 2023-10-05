package q00_ETC.rank6p.a1708;
/*
문제
다각형의 임의의 두 꼭짓점을 연결하는 선분이 항상 다각형 내부에 존재하는 다각형을 볼록 다각형이라고 한다. 아래 그림에서 (a)는 볼록 다각형이며, (b)는 볼록 다각형이 아니다.



조금만 생각해 보면 다각형의 모든 내각이 180도 이하일 때 볼록 다각형이 된다는 것을 알 수 있다. 편의상 이 문제에서는 180도 미만인 경우만을 볼록 다각형으로 한정하도록 한다.

2차원 평면에 N개의 점이 주어졌을 때, 이들 중 몇 개의 점을 골라 볼록 다각형을 만드는데, 나머지 모든 점을 내부에 포함하도록 할 수 있다. 이를 볼록 껍질 (CONVEX HULL) 이라 한다. 아래 그림은 N=10인 경우의 한 예이다.



점의 집합이 주어졌을 때, 볼록 껍질을 이루는 점의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N(3 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 점의 x좌표와 y좌표가 빈 칸을 사이에 두고 주어진다. 주어지는 모든 점의 좌표는 다르다. x좌표와 y좌표의 범위는 절댓값 40,000을 넘지 않는다. 입력으로 주어지는 다각형의 모든 점이 일직선을 이루는 경우는 없다.

출력
첫째 줄에 볼록 껍질을 이루는 점의 개수를 출력한다.

볼록 껍질의 변에 점이 여러 개 있는 경우에는 가장 양 끝 점만 개수에 포함한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	static Dot root;
	static class Dot implements Comparable<Dot> {
		double x, y, deg;
		Dot(double a, double b) {x = a; y = b;}
		@Override
		public int compareTo(Dot o) {
			int comp = Double.compare(o.deg, this.deg);
			if (comp != 0) return comp;
			return Double.compare(dist(root, o), dist(root, this));
		}
	}
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	root = new Dot(0, 40000);
		Dot[] dots = new Dot[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dots[i] = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			if (dots[i].y <= root.y) root = dots[i];
		}
		for(int i = 0; i < N; i++) dots[i].deg = deg(dots[i]);
		Arrays.sort(dots);
		Stack<Dot> s = new Stack<>() {{push(dots[0]); push(dots[1]);}};
		for(int i = 2; i < N; i++) {
			Dot cur = s.pop(), before = s.peek(), next = dots[i];
			if (ccw(before, cur, next) <= 0) i--;
			else {s.push(cur); s.push(next);}
		}
		Dot cur = s.pop(), before = s.peek(), next = dots[0];
		if (ccw(before, cur, next) > 0) s.push(cur);
    	System.out.print(s.size());        
    }
    static int in(String s) {return Integer.parseInt(s);}
    static double dist(Dot a, Dot b) {return Math.sqrt(Math.pow(a.x-b.x, 2) + Math.pow(a.y-b.y, 2));}
    static double deg(Dot d){
		if (root.x == d.x && root.y == d.y) return 7;
        double p12 = Math.pow(root.x+1, 2);
        double p23 = Math.pow(root.x-d.x, 2) + Math.pow(root.y-d.y, 2);
        double p31 = Math.pow(d.x+1, 2) + Math.pow(d.y-root.y, 2);
        return Math.acos((p12+p23-p31) / (2*Math.sqrt(p12)*Math.sqrt(p23)));
    }
    static double dist(Dot a, Dot l1, Dot l2) {
		double X, Y, dx = l1.x-l2.x, dy = l1.y-l2.y;
		if (dx == 0) {X = l1.x; Y = a.y;}
		else if (dy == 0) {X = a.x; Y = l1.y;}
		else {X = (dx/dy*a.x + dy/dx*l1.x + a.y - l1.y)/(dx/dy + dy/dx); Y = dy/dx*(X-l1.x) + l1.y;}
		return dist(a, new Dot(X, Y));
	}
	static double ccw(Dot a, Dot b, Dot c) {
        return a.x*b.y + b.x*c.y + c.x*a.y - a.x*c.y - c.x*b.y - b.x*a.y;
    }
}