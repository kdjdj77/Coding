package q72412;

/*

*/

import java.util.*;

class Node {
	Map<String, Node> next = new HashMap<>();
	public void insert(String[] arr) {
		Node cur = this;
		for(String s : arr) {
			cur.next.put(s, cur.next.getOrDefault(s, new Node()));
			cur = cur.next.get(s);
		}
	}
}
class Solution {
	static int res = 0;
	
	public static int[] solution(String[] info, String[] query) {
    	int[] ans = new int[query.length];
    	Node root = new Node();
    	
    	for(String s : info) {
    		String[] arr = s.split(" ");
    		root.insert(arr);
    	}
    	for(int c = 0; c < query.length; c++) {
    		res = 0;
    		String[] arr = query[c].replace(" and", "").split(" ");
    		ans[c] = search(root, arr, 0);
    	}
        return ans;
    }
    static int search(Node cur, String[] arr, int depth) {
    	int res = 0;
    	if (depth == arr.length-1) {
    		for(String t : cur.next.keySet())
    			if (Integer.valueOf(t) >= Integer.valueOf(arr[4])) res++;
    		return res;
    	}
    	
		if ("-".equals(arr[depth]))
			for(String s : cur.next.keySet())
				res += search(cur.next.get(s), arr, depth+1);
		else if (cur.next.keySet().contains(arr[depth])) {
			res = search(cur.next.get(arr[depth]), arr, depth+1);
		}
		return res;
    }
}