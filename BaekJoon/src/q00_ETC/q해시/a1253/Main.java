package q00_ETC.q해시.a1253;
/*
문제
N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.

N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.

수의 위치가 다르면 값이 같아도 다른 수이다.

입력
첫째 줄에는 수의 개수 N(1 ≤ N ≤ 2,000), 두 번째 줄에는 i번째 수를 나타내는 Ai가 N개 주어진다. (|Ai| ≤ 1,000,000,000, Ai는 정수)

출력
좋은 수의 개수를 첫 번째 줄에 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());		
		Map<Integer, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		
		int res = 0;
		Set<Integer> set = map.keySet();
		for(int n : set) for(int k : set) {
			if (n == 0 && k == 0 && map.get(0) < 3) continue; 
			if (n-k == 0 || k == 0) if (map.get(n) == 1) continue;
			if (n-k == k && map.get(k) == 1) continue;
			if (set.contains(n-k)) {
				res += map.get(n);
				break;
			}
		}
		System.out.print(N < 3 ? 0 : res);
    }
}