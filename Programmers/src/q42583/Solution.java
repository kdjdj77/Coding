package q42583;

/*

*/

import java.util.*;

class Solution {
    public int solution(int bl, int w, int[] tw) {
    	int idx = 0, time = 0, bw = 0;
    	Queue<Integer> q = new LinkedList<>();
    	for(int i = 0; i < bl; i++) q.add(0);
    	
    	while(true) {    		
    		time++;
    		if (q.size() == bl) bw -= q.poll();
    		
    		if (bw + tw[idx] > w) q.add(0);
    		else {
    			q.add(tw[idx]);
    			bw += tw[idx++];
    		}
    		
    		if (idx >= tw.length) return time + bl;
    	}
    }
}