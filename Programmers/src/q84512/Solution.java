package q84512;

/*

*/

class Solution {
	private final char[] c = new char[] {'A','E','I','O','U'};
	private boolean flag;
    public int solution(String word) {
    	char[] test = new char[5];
    	char[] str = new char[5];
    	for(int i = 0; i < word.length(); i++) str[i] = word.charAt(i);
    	flag = false;
    	return count(test, str, 0);
    }
    private int count(char[] test, char[] str, int depth) {
    	if (same(test, str)) flag = true;
    	if (flag) return 0;
    	
    	int res = 1;
    	if (depth > 4) return res;
    	for(int i = 0; i < 5; i++) {
    		test[depth] = c[i];
    		res += count(test, str, depth+1);
    		test[depth] = 0;
    	}
    	return res;
    }
    private boolean same(char[] test, char[] str) {
    	for(int i = 0; i < 5; i++) if (test[i] != str[i]) return false;
    	return true;
    }
}