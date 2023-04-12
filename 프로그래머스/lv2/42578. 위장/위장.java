import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
    	int ans = 1;
    	Map<String, Integer> map = new HashMap<>();
        for(String[] set : clothes)
        	map.put(set[1], map.getOrDefault(set[1], 0) + 1);
        
        for(Integer cnt : map.values()) ans *= cnt+1;
        return ans-1;
    }
}