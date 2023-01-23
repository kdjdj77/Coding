import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st, st2;

		int[] a = new int[4], b = new int[4];
		st = new StringTokenizer(br.readLine());
		st2 = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st2.nextToken());
		}

		boolean check1 = ccw(a,b[0],b[1]) * ccw(a,b[2],b[3]) < 0;
		boolean check2 = ccw(b,a[0],a[1]) * ccw(b,a[2],a[3]) < 0;
		System.out.print(check1 && check2 ? 1 : 0);
	}
	public static int ccw(int[] a, long x, long y) {
		long res = 0;
		res += (long)a[0]*a[3] + a[2]*y + x*a[1];
		res -= (long)a[1]*a[2] + a[3]*x + y*a[0];
		return res > 0 ? 1 : -1;
	}
}