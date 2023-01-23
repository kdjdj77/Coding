import java.io.*;
import java.util.*;

class Dot {
	long x, y;
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		Dot A1 = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Dot A2 = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Dot B1 = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Dot B2 = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		int b1 = ccw(A1, A2, B1), b2 = ccw(A1, A2, B2);
		int a1 = ccw(B1, B2, A1), a2 = ccw(B1, B2, A2);
		
		if (b1 == 0 && b2 == 0 & a1 == 0 & a2 == 0) {
			int n = isCrossed(A1, A2, B1, B2);
			sb.append(n > 0 ? 1 : 0);
			if (n == 1) {
				sb.append('\n');
                if (A1.x == B1.x && A1.y == B1.y || A1.x == B2.x && A1.y == B2.y)
                	sb.append(A1.x).append(" ").append(A1.y);
                if (A2.x == B1.x && A2.y == B1.y || A2.x == B2.x && A2.y == B2.y)
                	sb.append(A2.x).append(" ").append(A2.y);    
			}
		} else {
			boolean c1 = b1 * b2 <= 0;
			boolean c2 = a1 * a2 <= 0;
			if (c1 && c2) {
				sb.append(1).append("\n");
				double[] res = meet(A1, A2, B1, B2);
				sb.append(res[0]).append(" ").append(res[1]);
			} else sb.append(0);
		}
		System.out.print(sb);
	}
	static int ccw(Dot a, Dot b, Dot c) {
		long res = 0;
		res += a.x*b.y + b.x*c.y + c.x*a.y;
		res -= a.y*b.x + b.y*c.x + c.y*a.x;
		if (res != 0) return res > 0 ? 1 : -1;
		return 0;
	}
	static double[] meet(Dot a1, Dot a2, Dot b1, Dot b2) {
		double X, Y;
		if (a2.x-a1.x == 0) {
			double dYdX = (b2.y-b1.y)/(double)(b2.x-b1.x);
			X = a1.x;
			Y = dYdX * (X - b1.x) + b1.y;
		} else if (b2.x-b1.x == 0) {
			double dydx = (a2.y-a1.y)/(double)(a2.x-a1.x);
			X = b1.x;
			Y = dydx * (X - a1.x) + a1.y;
		} else {
			double dydx = (a2.y-a1.y)/(double)(a2.x-a1.x);
			double dYdX = (b2.y-b1.y)/(double)(b2.x-b1.x);
			X = (a1.y - b1.y + dYdX * b1.x - dydx * a1.x) / (dYdX - dydx);
			Y = dYdX * (X - b1.x) + b1.y;
		}
		return new double[] {X, Y};
	}
	static int isCrossed(Dot A1, Dot A2, Dot B1, Dot B2) {
        long minA, maxA, minB, maxB;
        if (A1.x == A2.x) {
            minA = Math.min(A1.y, A2.y); maxA = Math.max(A1.y, A2.y);
            minB = Math.min(B1.y, B2.y); maxB = Math.max(B1.y, B2.y);
        } else {
            minA = Math.min(A1.x, A2.x); maxA = Math.max(A1.x, A2.x);
            minB = Math.min(B1.x, B2.x); maxB = Math.max(B1.x, B2.x);
        }
        if (minA == maxB || maxA == minB) return 1;
        else if (minA < maxB && minB < maxA) return 2;
        else return 0;
    }
}