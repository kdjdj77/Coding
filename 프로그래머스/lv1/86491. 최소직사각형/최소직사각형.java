class Solution {
    public int solution(int[][] sizes) {
    	int maxX = 0, maxY = 0;
        for(int[] a : sizes) {
        	int x = Math.max(a[0], a[1]);
        	int y = Math.min(a[0], a[1]);
        	maxX = Math.max(x, maxX);
        	maxY = Math.max(y, maxY);
        }
        return maxX * maxY;
    }
}