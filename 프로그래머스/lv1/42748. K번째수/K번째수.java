import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
    	int ans[] = new int[commands.length], index = 0;
    	
        for(int[] com : commands) {    	
        	int arr[] = new int[com[1] - com[0] + 1], idx = 0;
        	for(int i = com[0] - 1; i < com[1]; i++) arr[idx++] = array[i];
        	Arrays.sort(arr);
        	ans[index++] = arr[com[2] - 1];
        }
        return ans;
    }
}