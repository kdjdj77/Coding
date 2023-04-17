import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
    	int[] res = new int[prices.length];
    	Stack<Integer> s = new Stack<>();
    	
        for(int t = 0; t < prices.length; t++) {
        	while (!s.isEmpty() && prices[s.peek()] > prices[t]) {
        		res[s.peek()] = t - s.peek();
        		s.pop();
        	}
        	s.add(t);
        }
        while(!s.isEmpty()) {
        	int tmp = s.pop();
        	res[tmp] = prices.length - tmp - 1;
        }
        return res;
    }
}