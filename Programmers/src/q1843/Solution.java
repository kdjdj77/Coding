package q1843;

/*

*/

import java.util.*;

import a출력객체.P;

class Solution {
    public int solution(String[] arr) {
    	int N = arr.length;
    	int[] nums = new int[N/2+1];
    	char[] signs = new char[N/2];
    	
    	nums[0] = Integer.parseInt(arr[0]);
    	for(int i = 1; i < N; i+=2) {
    		signs[i/2] = arr[i].charAt(0);
    		nums[i/2+1] = Integer.parseInt(arr[i+1]);
    	}
    	
    	
        return 0;
    }
}