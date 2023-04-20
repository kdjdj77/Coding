package q43164;

import java.util.*;

class Solution {
	private String[] res;
	private boolean flag;
	private int len;
	
    public String[] solution(String[][] tickets) {
    	Arrays.sort(tickets, new Comparator<>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[0].equals(o2[0]) ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]);
			}
    	});
    	
    	flag = false;
    	len = tickets.length;
    	boolean[] visit = new boolean[len];
    	String[] tmp = new String[len+1];
    	tmp[0] = "ICN";
		find(tickets, tmp, visit, 1);
    	return res;
    }
    private void find(String[][] tickets, String[] tmp, boolean[] visit, int idx) {
    	if (flag) return;
    	if (idx > len) {
    		res = Arrays.copyOf(tmp, tmp.length);
    		flag = true;
    		return;
    	}
    	for(int i = 0; i < len; i++) {
    		if (visit[i] || !tickets[i][0].equals(tmp[idx-1])) continue;
    		visit[i] = true;
    		tmp[idx] = tickets[i][1];
    		find(tickets, tmp, visit, idx+1);
    		visit[i] = false;
    	}
    }
}
