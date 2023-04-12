package q42747;

/*

*/

import java.util.*;

class Solution {
    public int solution(int[] citations) {
    	Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
    	Arrays.sort(arr, Collections.reverseOrder());
    	
    	int ans = 0;
    	for(int i = 0; i < arr.length; i++)
    		if (arr[i] >= i+1) ans = i+1;

    	return ans;
    }
}