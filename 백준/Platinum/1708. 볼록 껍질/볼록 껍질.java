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