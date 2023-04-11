package q42748;

/*

*/

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
    	int ans[] = new int[commands.length], idx = 0;
    	
        for(int[] com : commands) {    	
        	int[] arr = Arrays.copyOfRange(array, com[0]-1, com[1]);
        	Arrays.sort(arr);
        	ans[idx++] = arr[com[2]-1];
        }
        return ans;
    }
}