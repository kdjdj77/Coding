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

class Main{
    static class Dot{
        long x, y;
        public Dot(long x, long y) {this.x = x; this.y = y;}
    }
    static Dot root = new Dot(40001, 40001);
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Dot> dots = new ArrayList<Dot>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            dots.add(new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for(Dot d : dots){
            if (d.y < root.y) {root = d; continue;}
            if (d.y == root.y && d.x < root.x) root = d;
        }
        dots.sort(new Comparator<Dot>() {
            public int compare(Dot d1, Dot d2){
                int ccw = ccw(root, d1, d2);
                if (ccw != 0) return ccw < 0 ? 1 : -1;
                else return dist(root, d1) > dist(root, d2) ? 1 : -1;
            }
        });
        Stack<Dot> s = new Stack<Dot>() {{add(root);}};
        for(int i = 1; i < N; i++) {
    		while(s.size() > 1 && ccw(s.get(s.size()-2), s.get(s.size()-1), dots.get(i)) <= 0) s.pop();
            s.add(dots.get(i));
        }
        System.out.print(s.size());
    }
    static int ccw(Dot a, Dot b, Dot c){
        long res = (a.x*b.y + b.x*c.y + c.x*a.y) - (b.x*a.y + c.x*b.y + a.x*c.y);
        return res == 0 ? 0 : res > 0 ? 1 : -1;
    }
    static long dist(Dot a, Dot b){
        return (b.x-a.x)*(b.x-a.x) + (b.y-a.y)*(b.y-a.y);
    }
}