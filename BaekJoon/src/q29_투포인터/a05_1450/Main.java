package q29_투포인터.a05_1450;
/*
문제
세준이는 N개의 물건을 가지고 있고, 최대 C만큼의 무게를 넣을 수 있는 가방을 하나 가지고 있다.

N개의 물건을 가방에 넣는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 C가 주어진다. N은 30보다 작거나 같은 자연수, C는 109보다 작거나 같은 음이 아닌 정수이다. 
둘째 줄에 물건의 무게가 주어진다. 무게도 109보다 작거나 같은 자연수이다.

출력
첫째 줄에 가방에 넣는 방법의 수를 출력한다.
*/

import java.io.*;
import java.util.*;
 
public class Main {
	static int[] A;
	static int N, C;
	static ArrayList<Integer> A1 = new ArrayList<>();
	static ArrayList<Integer> A2 = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		A1.add(0); A2.add(0);
		calc(0, N/2, 0, true);
		calc(N/2, N, 0, false);
		Collections.sort(A2);
		
		int res = 0;
		for (int i = 0; i < A1.size(); i++) {
            int idx = -1;
            idx = bs(0, A2.size() - 1, A1.get(i));
            res += idx + 1;
        }
		System.out.print(res);
	}
	public static void calc(int s, int e, int sum, boolean f) {
		for(int i = s; i < e; i++) {
			if (sum + A[i] <= C) {
				if (f) A1.add(sum + A[i]);
				else A2.add(sum + A[i]);
				calc(i+1, e, sum + A[i], f);
			}
		}
	}
	public static int bs(int l, int r, int v) {
		int idx = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (A2.get(m)+v <= C) { idx = m++; l = m; }
            else r = --m;
        }
        return idx;
    }
}