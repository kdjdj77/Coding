import java.io.*;
import java.util.*;
 
public class Main {
	static final double r2 = Math.sqrt(2);
	static int res = 0, stats[] = new int[8];
	static boolean[] visit = new boolean[8];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 8; i++) stats[i] = Integer.parseInt(st.nextToken());
		setRes(1, new int[] {stats[0],0,0,0,0,0,0,0});
		System.out.print(res*8);
	}
	public static boolean ccw (int a1, int a2, int a3) {
		double d = (r2*a1*a3) / (a3 + a1);
		return a2 > d;
	}
	public static boolean isConvex(int[] a) {
		for(int i = 0; i < 8; i++)
			if (!ccw(a[i], a[(i+1)%8], a[(i+2)%8]))
				return false;
		return true;
	}
	public static void setRes(int depth, int[] tmp) {
		if (depth == 8) if (isConvex(tmp)) res++;
		for(int i = 1; i < 8; i++) {
			if (visit[i]) continue;
			visit[i] = true;
			tmp[depth] = stats[i];
			setRes(depth+1, tmp);
			visit[i] = false;
		}
	}
}