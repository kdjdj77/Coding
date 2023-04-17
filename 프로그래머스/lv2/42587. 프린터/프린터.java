import java.util.*;

class Doc {
	int idx;
	int p;
	Doc(int i, int p) {
		this.idx = i;
		this.p = p;
	}
}
class Solution {
    public int solution(int[] priorities, int location) {
    	int res = 0;
    	Queue<Doc> q = new LinkedList<>();
    	for(int i = 0; i < priorities.length; i++)
    		q.add(new Doc(i, priorities[i]));
    	
    	while(!q.isEmpty()) {
    		Doc tmp = q.peek();
    		boolean isHigh = true;
    		for(Doc d : q) {
    			if (tmp.p >= d.p) continue;
				q.add(q.poll());
				isHigh = false;
				break;
    		}
    		if (isHigh) {
    			Doc d = q.poll();
    			res++;
    			if (d.idx == location) return res;
    		}
    	}
        return 0;
    }
}