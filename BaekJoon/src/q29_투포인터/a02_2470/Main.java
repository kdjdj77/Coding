package q29_투포인터.a02_2470;
/*
5
-99 -2 -1 4 98
*/

import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		
		int s = 0, e = N-1;
		int a = 0, b = 0, min = Integer.MAX_VALUE;
		while(s < e) {
			int sum = A[s] + A[e];
			if (sum == 0) { a = s; b = e; break; }
			else if (sum < 0) {
				if (min > -sum) { min = -sum; a = s; b = e; }
				s++; 
			}
			else {
				if (min > sum) { min = sum; a = s; b = e; }
				e--; 
			}
		}
		sb.append(A[a]).append(" ").append(A[b]);
		System.out.print(sb);
	}
}