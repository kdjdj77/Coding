import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < speeds.length; i++) {
        	int d = (100 - progresses[i]) / speeds[i];
        	if ((100 - progresses[i]) % speeds[i] != 0) d++;
        	q.add(d);
        }
        
        int day = q.peek(), cnt = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
        	if (day >= q.peek()) {
        		q.poll();
        		cnt++;
        	} else {
        		res.add(cnt);
        		day = q.peek();
        		cnt = 0;
        	}
        }
        if (cnt != 0) res.add(cnt);
        return res.stream().mapToInt(i->i).toArray();
    }
}