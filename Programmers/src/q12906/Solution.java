package q12906;

/*

*/

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        q.add(arr[0]);
        int before = arr[0];
        for(int i = 1; i < arr.length; i++) {
        	if (arr[i] == before) continue;
        	res.add(q.poll());
        	q.add(before = arr[i]);
        }
        res.add(q.poll());
        return res.stream().mapToInt(i -> i).toArray();
    }
}