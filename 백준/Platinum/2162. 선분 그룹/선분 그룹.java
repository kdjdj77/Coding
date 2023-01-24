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