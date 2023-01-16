import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N], idx = new int[N], path = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		path[0] = A[0];
		idx[0] = 1;
		int max = 1;
		for (int i = 1; i < N; i++) {
			if (path[max - 1] < A[i]) {
				path[max] = A[i];
				idx[i] = ++max;
			} else {
				int index = bs(0, max-1, A[i], path);
				path[index] = A[i];
				idx[i] = index + 1;
			}
		}
		sb.append(max).append("\n");
		
		int find = path[max - 1] + 1;
		int[] res = new int[max];
		for (int i = N-1; i >= 0; i--) {
			if (max < 1) break;
			if (idx[i] == max) { find = A[i]; res[--max] = find; }
		}
		for (int a : res) sb.append(a).append(" ");
		
		System.out.println(sb.toString());
	}
	private static int bs(int l, int r, int num, int[] path) {
		int m;
		while (l < r) {
			m = (l + r) / 2;
			if (path[m] < num) l = m + 1;
			else r = m;
		}
		return r;
	}
}