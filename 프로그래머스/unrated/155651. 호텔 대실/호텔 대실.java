import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
    	int N = book_time.length;
    	int[][] time = new int[N][2];
    	for(int i = 0; i < N; i++) {
    		time[i][0] = t(book_time[i][0]);
    		time[i][1] = t(book_time[i][1]);
    	}
    	Arrays.sort(time, new Comparator<>() {
    		@Override
    		public int compare(int[] i1, int[] i2) {
    			return i1[0] - i2[0];
    		}
    	});
    	
    	ArrayList<Integer> room = new ArrayList<>();
    	for(int i = 0; i < N; i++) {
    		int idx = -1;
    		int min = Integer.MAX_VALUE;
    		for(int j = 0; j < room.size(); j++) {
    			if (room.get(j) + 9 < time[i][0]) {
    				min = Math.min(min, time[i][1]);
    				idx = j;
    			}
    		}
    		if (idx == -1) room.add(time[i][1]);
    		else room.set(idx, min);
    	}
        return room.size();
    }
    private int t(String time) {
    	StringTokenizer st = new StringTokenizer(time, ":");
    	int h = Integer.parseInt(st.nextToken()) * 60;
    	int m = Integer.parseInt(st.nextToken());
    	return h + m;
    }
}