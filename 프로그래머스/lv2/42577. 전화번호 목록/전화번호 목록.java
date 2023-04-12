import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
    	Set<String> set = new HashSet<String>(Arrays.asList(phone_book));
    	for(String s : phone_book) {
    		for(int i = 0; i < s.length(); i++) {
    			String find = s.substring(0, i);
    			if (set.contains(find)) return false;
    		}
    	}
    	return true;
    }
}