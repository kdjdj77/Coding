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
	static Dot rt = new Dot(40001, 40001);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Dot[] dots = new Dot[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            dots[i] = new Dot(x, y);
        }
        for(int i = 0; i < N; i++) {
            if (dots[i].y < rt.y) {rt = dots[i]; continue;}
            if (dots[i].x < rt.x && dots[i].y == rt.y) rt = dots[i];
        }
        Arrays.sort(dots, new Comparator<Dot>() {
            @Override
            public int compare(Dot d1, Dot d2) {
                int res = ccw(rt, d1, d2);
                if (res == 0) {
                	long dist1 = dist(rt, d1), dist2 = dist(rt, d2);
                	return dist1 == dist2 ? 0 : dist1 > dist2 ? 1 : -1;
                }
                return res > 0 ? -1 : 1;
            }
        });
        Stack<Dot> s = new Stack<>() {{add(rt);}};
        for(int i = 1; i < N; s.add(dots[i++])) while(s.size() > 1) {
        	Dot cur = s.pop(), before = s.peek();
        	if (ccw(before, cur, dots[i]) > 0) {s.add(cur); break;}
        }
        System.out.print(s.size());
    }
    static int ccw(Dot p1, Dot p2, Dot p3) {
        long res = p1.x*p2.y + p2.x*p3.y + p3.x*p1.y - p2.x*p1.y - p3.x*p2.y - p1.x*p3.y;
        return res == 0 ? 0 : res > 0 ? 1 : -1;
    }
    static long dist(Dot p1, Dot p2) {
    	long dx = p2.x-p1.x, dy = p2.y-p1.y;
        return dx*dx + dy*dy;
    }
    static class Dot {
        int x, y;
        Dot(int x, int y) {this.x = x; this.y = y;}
    }
}