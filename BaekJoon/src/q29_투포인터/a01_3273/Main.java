package q29_투포인터.a01_3273;
/*
9
5 12 7 10 9 1 2 3 11
13
*/

import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(br.readLine());
		Arrays.sort(A);
		
		int s = 0, e = N-1, res = 0;
		while(s < e) {
			int sum = A[s] + A[e];
			if (sum == X) { s++; e--; res++; }
			else if (sum < X) s++;
			else e--;
		}
		System.out.print(res);
	}
}



