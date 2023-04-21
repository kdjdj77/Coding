package q43163;

/*

*/

import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int N = words.length, idx = -1;
		int[] dp = new int[N];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < N; i++) {
        	if (t(begin, words[i])) { q.add(i); dp[i]++; }
        	if (words[i].equals(target)) idx = i;
        }
        if (idx == -1) return 0;
    	while(!q.isEmpty()) {
    		int a = q.poll();
    		for(int b = 0; b < N; b++) {
    			if (dp[b] > 0 || !t(words[a], words[b])) continue;
    			dp[b] = dp[a] + 1;
    			q.add(b);
    		}
    	}
        return dp[idx];
    }
    private boolean t(String start, String check) {
    	int L = start.length(), cnt = 0;
    	for(int i = 0; i < L; i++) {
    		if (start.charAt(i) != check.charAt(i)) cnt++;
    		if (cnt > 1) return false;
    	}
    	return true;
    }
}