class Solution {
    public String solution(String s, int n) {
    	StringBuilder ans = new StringBuilder();
        char[] arr = s.toCharArray();
        
        n = n % 26;
        for(char c : arr) ans.append(getChar(c, n));
        return ans.toString();
    }
    char getChar(char c, int n) {
    	if (c != ' ') {
    		if (65 <= c && c <= 90) {
    			if (c + n > 90) c = (char)(c + n - 26);
    			else c = (char)(c + n);
    		}
    		else if (97 <= c && c <= 122) {
    			if (c + n > 122) c = (char)(c + n - 26);
    			else c = (char)(c + n);
    		}
    	}
    	return c;
    }
}