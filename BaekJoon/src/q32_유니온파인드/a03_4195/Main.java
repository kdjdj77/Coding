package q32_유니온파인드.a03_4195;
/*
문제
민혁이는 소셜 네트워크 사이트에서 친구를 만드는 것을 좋아하는 친구이다. 우표를 모으는 취미가 있듯이, 
민혁이는 소셜 네트워크 사이트에서 친구를 모으는 것이 취미이다.

어떤 사이트의 친구 관계가 생긴 순서대로 주어졌을 때, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.

친구 네트워크란 친구 관계만으로 이동할 수 있는 사이를 말한다.

입력
첫째 줄에 테스트 케이스의 개수가 주어진다. 
각 테스트 케이스의 첫째 줄에는 친구 관계의 수 F가 주어지며, 이 값은 100,000을 넘지 않는다. 
다음 F개의 줄에는 친구 관계가 생긴 순서대로 주어진다. 
친구 관계는 두 사용자의 아이디로 이루어져 있으며, 알파벳 대문자 또는 소문자로만 이루어진 길이 20 이하의 문자열이다.

출력
친구 관계가 생길 때마다, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.
*/

import java.io.*;
import java.util.*;
 
public class Main {
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			A = new int[2000001];
			int idx = 0;
			
			Map<String, Integer> map = new HashMap<>();
			int M = Integer.parseInt(br.readLine());
			while(M-- > 0) {
				st = new StringTokenizer(br.readLine());
				String x = st.nextToken();
				String y = st.nextToken();
				if (!map.containsKey(x)) { map.put(x, ++idx); A[idx] = -1; }
				if (!map.containsKey(y)) { map.put(y, ++idx); A[idx] = -1; }
				union(map.get(x), map.get(y));
				sb.append(Math.abs(A[root(map.get(x))])).append("\n");
			}
		}
		System.out.print(sb);
	}
	public static int root(int x) {
		return A[x] < 0 ? x : root(A[x]);
	}
	public static void union(int x, int y) {
        x = root(x); y = root(y);
        if (x == y) return;
        if (A[x] < A[y]) { A[x] += A[y]; A[y] = x; }
        else { A[y] += A[x]; A[x] = y; }
    }
}