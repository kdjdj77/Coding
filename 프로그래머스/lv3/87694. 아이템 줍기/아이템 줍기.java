import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
    	int[] start = new int[] {characterX*2, characterY*2};
    	int[] item = new int[] {itemX*2, itemY*2};
    	
    	Set<String> dot = setDots(rectangle);
    	ArrayList<int[]> dots = new ArrayList<>();
    	
    	for(String s : dot) {
    		String[] tmp = s.split(" ");
    		int[] d = new int[] {Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])};
    		dots.add(d);
    	}
    	int dist = find(new int[] {-1, -1}, start, dots, item, 0);
    	return Math.min(dist/2, (dot.size() - dist)/2);
    }
    private int find(int[] before, int[] cur, ArrayList<int[]> dot, int[] item, int depth) {
    	if (same(cur, item)) return depth;
    	int res = Integer.MAX_VALUE;
    	for(int i = 0; i < dot.size(); i++) {
    		if (!is1Dist(cur, dot.get(i))) continue;
    		if (same(before, dot.get(i))) continue;
    		res = Math.min(res, find(cur, dot.get(i), dot, item, depth+1));
    	}
    	return res;
    }
    private boolean same(int[] a, int[] b) {
    	return a[0] == b[0] && a[1] == b[1];
    }
    private boolean is1Dist(int[] a, int[] b) {
    	int d1 = Math.abs(a[0] - b[0]);
    	int d2 = Math.abs(a[1] - b[1]);
    	return d1 + d2 == 1 ? true : false;
    }
    private Set<String> setDots(int[][] rectangle) {
    	StringBuilder sb;
    	for(int i = 0; i < rectangle.length; i++)
    		for(int j = 0; j < 4; j++)
    			rectangle[i][j] *= 2;
    	
    	Set<String> res = new HashSet<String>();
    	for(int[] rec : rectangle) {
    		ArrayList<int[]> arr = new ArrayList<>();
    		for(int i = rec[1]; i < rec[3]; i++) arr.add(new int[] {rec[0], i});
    		for(int i = rec[0]; i < rec[2]; i++) arr.add(new int[] {i, rec[3]});
    		for(int i = rec[3]; i > rec[1]; i--) arr.add(new int[] {rec[2], i});
    		for(int i = rec[2]; i > rec[0]; i--) arr.add(new int[] {i, rec[1]});
    		
    		for(int[] d : arr) {
    			boolean flag = true;
    			for(int[] re : rectangle) {
    				if (re[0] < d[0] && d[0] < re[2] && re[1] < d[1] && d[1] < re[3]) {
    					flag = false;
    					break;
    				}
    			}
    			sb = new StringBuilder();
    			if (flag) {
    				sb = new StringBuilder();
    				sb.append(d[0]).append(" ").append(d[1]);
    				res.add(sb.toString());
    			}
    		}
    	}
    	return res;
    }
}