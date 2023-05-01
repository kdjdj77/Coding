import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	int res = 0;
    	
    	for(int s : scoville) pq.add(s);
    	while(true) {
    		int cur = pq.poll();
    		if (cur >= K) return res;
    		
    		if (pq.isEmpty()) {
    			res = -1;
    			break;
    		}
    		pq.add(cur + pq.poll()*2);
    		res++;
    	}
        return res;
    }
}