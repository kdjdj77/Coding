import java.util.*;

class Solution {
    public int[] solution(int[] nums) {
    	int N = nums.length;
    	Stack<Integer> s = new Stack<>();
    	for(int i = 0; i < N; i++) {
			while(!s.isEmpty() && nums[s.peek()] < nums[i]) nums[s.pop()] = nums[i];
			s.push(i);
		}
		while(!s.isEmpty()) nums[s.pop()] = -1;
        return nums;
    }
}