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