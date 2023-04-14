package q42586;

/*

*/

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    	ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < speeds.length; i++)
        	q.add((int) Math.ceil((double)(100 - progresses[i]) / speeds[i]));
        
        int day = q.peek(), cnt = 0;
        while(!q.isEmpty()) {
        	if (day >= q.peek()) { q.poll(); cnt++; continue; }
    		res.add(cnt);
    		day = q.peek();
    		cnt = 0;
        }
        res.add(cnt);
        return res.stream().mapToInt(i->i).toArray();
    }
}