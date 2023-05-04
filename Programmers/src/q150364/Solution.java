package q150364;

/*

*/

import java.util.*;

class Solution {
	private int N, T[], res[];
    public int[] solution(int[][] edges, int[] target) {
    	
    	
    	
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