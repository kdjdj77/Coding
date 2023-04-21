import java.util.*;

class Solution {
	private int[] dp;
    public int solution(String begin, String target, String[] words) {
        int idx = -1;
        dp = new int[words.length];
        
        for(int i = 0; i < words.length; i++) {
        	if (t(begin, words[i])) dp[i] = 1;
        	if (words[i].equals(target)) idx = i;
        }
        
        bfs(words);
        return idx == -1 ? 0 : dp[idx];
    }
    private void bfs(String[] words) {
    	Queue<Integer> q = new LinkedList<>();
    	for(int i = 0; i < words.length; i++) if (dp[i] > 0) q.add(i);
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		
    		for(int i = 0; i < words.length; i++) {
    			if (dp[i] > 0) continue;
    			if (!t(words[cur], words[i])) continue;
    			q.add(i);
    			dp[i] = dp[cur] + 1;
    		}
    	}
    }
    private boolean t(String start, String check) {
    	int N = start.length();
    	int cnt = 0;
    	for(int i = 0; i < N; i++) {
    		if (start.charAt(i) != check.charAt(i)) cnt++;
    		if (cnt > 1) return false;
    	}
    	return true;
    }
}