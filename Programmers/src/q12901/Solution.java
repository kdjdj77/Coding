package q12901;

/*

*/

class Solution {
    public String solution(int a, int b) {
    	String[] arr = new String[] { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" };
    	int[] days = new int[] { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    	
    	int res = 0;
		for(int i = 1; i < a; i++) res += days[i]; 
		res += b;
    	
    	String ans = arr[res % 7];
        return ans;
    }
}