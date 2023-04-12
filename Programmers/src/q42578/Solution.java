package q42578;

/*

*/

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
    	int res = 1;
    	Map<String, Integer> map = new HashMap<>();
        for(String[] c : clothes)
        	map.put(c[1], map.getOrDefault(c[1], 1) + 1);
        
        for(Integer cnt : map.values()) res *= cnt;
        return res-1;
    }
}