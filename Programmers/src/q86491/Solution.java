package q86491;

/*

*/

class Solution {
    public int solution(int[][] sizes) {
    	int maxX = 0, maxY = 0;
        for(int[] a : sizes) {
        	maxX = Math.max(Math.max(a[0], a[1]), maxX);
        	maxY = Math.max(Math.min(a[0], a[1]), maxY);
        }
        return maxX * maxY;
    }
}