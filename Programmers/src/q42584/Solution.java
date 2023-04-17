package q42584;

/*

*/

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
    	int[] res = new int[prices.length];
    	Stack<Integer> s = new Stack<>();
    	
    	s.add(0);
        for(int t = 1; t < prices.length; t++) {
        	while (!s.isEmpty() && prices[s.peek()] > prices[t])
        		res[s.peek()] = t - s.pop();
        	s.add(t);
        }
        while(!s.isEmpty())
        	res[s.peek()] = prices.length - s.pop() - 1;
        
        return res;
    }
}