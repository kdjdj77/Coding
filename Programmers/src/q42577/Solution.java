package q42577;

/*

*/

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
    	Set<String> set = new HashSet<String>(Arrays.asList(phone_book));
    	for(String s : phone_book)
    		for(int i = 0; i < s.length(); i++)
    			if (set.contains(s.substring(0, i))) return false;
    	return true;
    }
}