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
			int n = overlap(A1, A2, B1, B2);
			sb.append(n > 0 ? 1 : 0);
			if (n == 1) {
				sb.append('\n');
                if (A1.x == B1.x && A1.y == B1.y || A1.x == B2.x && A1.y == B2.y)
                	sb.append(A1.x).append(" ").append(A1.y);
                if (A2.x == B1.x && A2.y == B1.y || A2.x == B2.x && A2.y == B2.y)
                	sb.append(A2.x).append(" ").append(A2.y);    
			}
		} else if (b1 * b2 <= 0 && a1 * a2 <= 0) {
			sb.append(1).append("\n");
			double[] res = meet(A1, A2, B1, B2);
			sb.append(res[0]).append(" ").append(res[1]);
		} else sb.append(0);
		System.out.print(sb);
	}
	static int ccw(Dot a, Dot b, Dot c) {
		long l = a.x*b.y + b.x*c.y + c.x*a.y - a.y*b.x - b.y*c.x - c.y*a.x;
		if (l != 0) return l > 0 ? 1 : -1;
		return 0;
	}
	static double[] meet(Dot A1, Dot A2, Dot B1, Dot B2) {
		double X, Y;
		if (A2.x-A1.x == 0) {
			X = A1.x;
			Y = (B2.y-B1.y)/(double)(B2.x-B1.x) * (X - B1.x) + B1.y;
		} else if (B2.x-B1.x == 0) {
			X = B1.x;
			Y = (A2.y-A1.y)/(double)(A2.x-A1.x) * (X - A1.x) + A1.y;
		} else {
			double iA = (A2.y-A1.y)/(double)(A2.x-A1.x);
			double iB = (B2.y-B1.y)/(double)(B2.x-B1.x);
			X = (A1.y - B1.y + iB * B1.x - iA * A1.x) / (iB - iA);
			Y = iB * (X - B1.x) + B1.y;
		}
		return new double[] {X, Y};
	}
	static int overlap(Dot A1, Dot A2, Dot B1, Dot B2) {
        long[] sA, sB;
        if (A1.x == A2.x) {
        	sA = new long[] {A1.y, A2.y};
        	sB = new long[] {B1.y, B2.y};
        } else {
        	sA = new long[] {A1.x, A2.x};
        	sB = new long[] {B1.x, B2.x};
        }
        Arrays.sort(sA); Arrays.sort(sB);
        if (sA[0]==sB[1] || sA[1]==sB[0]) return 1;
        else if (sA[0]<sB[1] && sB[0]<sA[1]) return 2;
        else return 0;
    }
}