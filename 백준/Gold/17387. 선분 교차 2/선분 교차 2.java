import java.io.*;
import java.util.*;

class Dot {
	int x, y;
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public long dist() {
		return (long)(Math.pow(this.x, 2) + Math.pow(this.y, 2));
	}
}
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int res = 0;
		st = new StringTokenizer(br.readLine());
		Dot A1 = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Dot A2 = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Dot B1 = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Dot B2 = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		int b1 = ccw(A1, A2, B1), b2 = ccw(A1, A2, B2);
		int a1 = ccw(B1, B2, A1), a2 = ccw(B1, B2, A2);
		
		if (b1 == 0 && b2 == 0 & a1 == 0 & a2 == 0) {
			long d1 = Math.min(B1.dist(), B2.dist());
			long d2 = Math.min(A1.dist(), A2.dist());
			boolean c1 = A1.dist() < d1 && A2.dist() < d1;
			boolean c2 = B1.dist() < d2 && B2.dist() < d2;
			res = c1 || c2 ? 0 : 1;
		} else {
			boolean c1 = b1 * b2 <= 0;
			boolean c2 = a1 * a2 <= 0;
			res = c1 && c2 ? 1 : 0;
		}
		System.out.print(res);
	}
	public static int ccw(Dot a, Dot b, Dot c) {
		long res = 0;
		res += (long)a.x*b.y + (long)b.x*c.y + (long)c.x*a.y;
		res -= (long)a.y*b.x + (long)b.y*c.x + (long)c.y*a.x;
		if (res != 0) return res > 0 ? 1 : -1;
		return 0;
	}
}