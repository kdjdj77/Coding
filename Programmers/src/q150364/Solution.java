package q150364;

/*

*/

import java.util.*;

class Solution {
	private int N, T[], res[];
    public int[] solution(int[][] edges, int[] target) {
    	T = target;
    	N = edges.length;
    	boolean[] shut = new boolean[N];
    	
    	Arrays.sort(edges, new Comparator<>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
			}
    	});
    	
    	Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    	for(int i = 0; i <= N; i++) map.put(i+1, new ArrayList<>());
    	for(int i = 0; i < N; i++) map.get(edges[i][0]).add(i);
    	
    	calc()
    	
        return new int[] {};
    }
    // -1:불가, 0:일치, 1:가능
    private int isOk(int[] tmp) {
    	boolean flag = false;
    	for(int i = 0; i < T.length; i++) {
    		if (tmp[i] > T[i]) return -1;
    		if (tmp[i] < T[i]) flag = true;
    	}
    	return flag ? 1 : 0;
    }
}