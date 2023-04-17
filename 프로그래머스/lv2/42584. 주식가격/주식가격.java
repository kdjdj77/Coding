import java.util.*;

class P {
	int t;
	int p;
	P (int t, int p) {
		this.t = t;
		this.p = p;
	}
}
class Solution {
    public int[] solution(int[] prices) {
    	int[] res = new int[prices.length];
    	Stack<P> s = new Stack<>();
    	s.add(new P(-1, 0));
    	
        for(int t = 0; t < prices.length; t++) {
        	while (s.peek().p > prices[t]) {
        		res[s.peek().t] = t - s.peek().t;
        		s.pop();
        	}
        	s.add(new P(t, prices[t]));
        }
        while(s.size() > 1) {
        	P tmp = s.pop();
        	res[tmp.t] = prices.length - tmp.t - 1;
        }
        return res;
    }
}