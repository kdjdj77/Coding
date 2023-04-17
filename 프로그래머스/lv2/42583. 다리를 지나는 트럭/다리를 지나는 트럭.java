import java.util.*;

class Solution {
    public int solution(int bl, int w, int[] tw) {
    	int idx = 0, time = 0;
    	Queue<Integer> q = new LinkedList<>();
    	for(int i = 0; i < bl; i++) q.add(0);
    	
    	while(true) {
    		time++;
    		q.poll();
    		
    		int bw = 0;
    		for(int weight : q) bw += weight;
    		
    		if (bw + tw[idx] > w) q.add(0);
    		else q.add(tw[idx++]);
    		
    		if (idx >= tw.length) return time + bl;
    	}
    }
}