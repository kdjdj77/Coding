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
			if (comp == 0) return Double.compare(dist(root, o), dist(root, this));
			return comp;
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
				Dot second = s.pop(), first = s.peek(), next = dots[i];
				if (ccw(first, second, next) < 0) i--;
				else {s.push(second); s.push(next);}
			}
			int size = s.size();
			Dot[] border = new Dot[size];
			for(int i = 0; i < size; i++) border[i] = s.pop();
			double res = 10000;
			for(int i = 0, len = border.length; i < len; i++) {
				int line1 = i, line2 = (i+1)%len;
				double max = 0;
				for(int cur = 0; cur < len; cur++) if (cur != line1 && cur != line2)
					max = Math.max(max, dist(border[cur], border[line1], border[line2]));
				res = Math.min(res, max);
			}
			sb.append("Case ").append(tc).append(": ");
			sb.append(String.format("%.2f", Math.ceil(res*100)/100)).append("\n");
		}
		System.out.print(sb);
	}
	static double in() throws IOException {
    	if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
    	return Double.parseDouble(st.nextToken());
    }
	public static double deg(Dot d){
		if (root.x == d.x && root.y == d.y) return 7;
        double p12 = Math.pow(root.x+1, 2);
        double p23 = Math.pow(root.x-d.x, 2) + Math.pow(root.y-d.y, 2);
        double p31 = Math.pow(d.x+1, 2) + Math.pow(d.y-root.y, 2);
        return Math.acos((p12+p23-p31) / (2*Math.sqrt(p12)*Math.sqrt(p23)));
    }
	static int ccw(Dot a, Dot b, Dot c) {
        double res = (a.x*b.y + b.x*c.y + c.x*a.y) - (a.x*c.y + c.x*b.y + b.x*a.y);
        return res < 0 ? -1 : 1;
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