package q29_투포인터.a03_1806;
/*
10 15
5 1 3 5 10 7 4 9 2 8

ans : 2
*/

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		int s = 0, e = 0, res = N, sum = A[0];
		while(s < N && e < N-1) {
			if (sum < S) sum += A[++e];
			else {
				if (e-s < res) res = e-s;
				sum -= A[s++];
			}
		}
		System.out.print(res+1);
	}
}