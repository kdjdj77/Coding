package q154538;

/*
문제 설명
자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.

x에 n을 더합니다
x에 2를 곱합니다.
x에 3을 곱합니다.
자연수 x, y, n이 매개변수로 주어질 때, x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요. 이때 x를 y로 만들 수 없다면 -1을 return 해주세요.

제한사항
1 ≤ x ≤ y ≤ 1,000,000
1 ≤ n < y
*/

import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
    	if (x == y) return 0;
    	int[] dp = new int[y+1];
    	
    	Queue<Integer> q = new LinkedList<>();
    	q.add(x);
    	
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		for(int next : new int[] {cur+n, cur*2, cur*3}) {
    			if (next > y || dp[next] != 0) continue;
    			dp[next] = dp[cur] + 1;
    			q.add(next);
    		}
    	}
    	return dp[y] == 0 ? -1 : dp[y];
    }
}