package q00_ETC.rank6.a4225;
/*
문제
선영이는 쓰레기를 편하게 버리기 위해서 빌딩에 쓰레기 슈트를 만들었다. 쓰레기 슈트는 빌딩에 설치할 수 있는 속이 빈 튜브다. 튜브로 쓰레기를 떨어뜨리면, 쓰레기는 지하실까지 떨어지게 된다.

쓰레기 슈트를 만드는 일은 매우 어려운 일이다. 사람들이 무엇을 버릴지 알 수 없기 때문에, 쓰레기 슈트에 들어가지 않는 쓰레기를 버린다면, 슈트가 막혀버릴 수 있기 때문이다. 쓰레기 슈트를 만드는데 드는 비용은 그 크기에 비례한다. 따라서, 최대한 작게 만드는 것이 효율적이다.

먼저, 쓰레기 슈트를 만드는 문제를 2차원으로 단순화 시켜보자. 슈트는 일정한 너비를 가지고 있고, 다각형으로 모델링된 물체를 이 곳의 상단에 넣을 수 있다.

물체를 넣기 전에, 슈트에 들어갈 수 있게 돌려야 할 수도 있다. 슈트에 던진 이후에는 일직선으로 아래로 떨어지고, 그 동안 물체는 회전하지 않는다.

아래 그림은 물체를 쓰레기 슈트에 들어갈 수 있게 회전시킨 다음 버리는 그림이다.



어떤 물체가 주어진다. 이 물체가 통과할 수 있는 가장 작은 슈트의 너비를 구하는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 물체(다각형)의 꼭짓점의 개수 n이 주어진다. (3 ≤ n ≤ 100)

다음 n개 줄에는 꼭짓점의 좌표 xi와 yi가 주어진다. (0 ≤ xi, yi ≤ 104) 꼭짓점은 다각형을 이루는 순서대로 주어진다. 

입력으로 주어지는 다각형의 좌표는 모두 서로 다르며, 다각형의 변은 교차하지 않는다. 엄밀히 따지면, 인접한 변은 한 꼭짓점을 공유한다는 예외가 하나 있다. 물론, 이 경우는 교차하는 것으로 생각하지 않는다.

마지막 테스트 케이스의 다음 줄에는 0이 하나 주어진다.

출력
각 테스트 케이스마다 케이스 번호와 가장 작은 쓰레기 슈트의 너비를 출력한다. 너비는 가장 가까운 0.01의 배수로 올림하여 소수점 둘째 자리까지 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer("");
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
		StringBuilder sb = new StringBuilder();
		int N, tc = 0;
		while((N = Integer.parseInt(br.readLine())) != 0) {
			tc++;
			root = new Dot(0, 10000);
			Dot[] dots = new Dot[N];
			for(int i = 0; i < N; i++) if ((dots[i] = new Dot(in(), in())).y <= root.y) root = dots[i];
			for(int i = 0; i < N; i++) dots[i].deg = deg(dots[i]);
			Arrays.sort(dots);
			Stack<Dot> s = new Stack<>(); s.push(dots[0]); s.push(dots[1]);
			for(int i = 2; i < N; i++) {
				Dot cur = s.pop(), before = s.peek(), next = dots[i];
				if (ccw(before, cur, next) < 0) i--;
				else {s.push(cur); s.push(next);}
			}
			double res = 10000;
			Dot[] border = s.toArray(new Dot[0]);
			for(int i = 0, len = border.length; i < len; i++) {
				int l1 = i, l2 = (i+1)%len;
				double max = 0;
				for(int cur = 0; cur < len; cur++) if (cur != l1 && cur != l2)
					max = Math.max(max, dist(border[cur], border[l1], border[l2]));
				res = Math.min(res, max);
			}
			String ans = String.format("%.2f", Math.ceil(res*100)/100);
			sb.append("Case ").append(tc).append(": ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
	static double in() throws IOException {
    	if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
    	return Double.parseDouble(st.nextToken());
    }
	static double deg(Dot d){
		if (root.x == d.x && root.y == d.y) return 7;
        double p12 = Math.pow(root.x+1, 2);
        double p23 = Math.pow(root.x-d.x, 2) + Math.pow(root.y-d.y, 2);
        double p31 = Math.pow(d.x+1, 2) + Math.pow(d.y-root.y, 2);
        return Math.acos((p12+p23-p31) / (2*Math.sqrt(p12)*Math.sqrt(p23)));
    }
	static double ccw(Dot a, Dot b, Dot c) {
        return a.x*b.y + b.x*c.y + c.x*a.y - a.x*c.y - c.x*b.y - b.x*a.y;
    }
	static double dist(Dot a, Dot l1, Dot l2) {
		double X, Y, dx = l1.x-l2.x, dy = l1.y-l2.y;
		if (dx == 0) {X = l1.x; Y = a.y;}
		else if (dy == 0) {X = a.x; Y = l1.y;}
		else {X = (dx/dy*a.x + dy/dx*l1.x + a.y - l1.y)/(dx/dy + dy/dx); Y = dy/dx*(X-l1.x) + l1.y;}
		return dist(a, new Dot(X, Y));
	}
	static double dist(Dot a, Dot b) {return Math.sqrt(Math.pow(a.x-b.x, 2) + Math.pow(a.y-b.y, 2));}
}