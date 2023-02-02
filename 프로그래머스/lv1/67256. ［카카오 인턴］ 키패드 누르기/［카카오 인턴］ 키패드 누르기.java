class Pos {
	int x, y;
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int dist(Pos p) {
		int dx = Math.abs(this.x - p.x);
		int dy = Math.abs(this.y - p.y);
		return dx + dy;
	}
}
class Solution {
    public String solution(int[] numbers, String hand) {
    	StringBuilder sb = new StringBuilder();
    	
    	boolean isRH = hand.equals("right");
    	Pos[] pos = new Pos[12];
		pos[0] = new Pos(3, 1);
		pos[10] = new Pos(3, 0);
		pos[11] = new Pos(3, 2);
		for(int i = 1; i < 10; i++) pos[i] = new Pos((i-1)/3, (i-1)%3);
		
    	int leftCur = 10, rightCur = 11;
    	
        for(int i : numbers) {
        	switch(i) {
	        	case 1: case 4: case 7:
	        		sb.append("L");
	        		leftCur = i;
	        		break;
	        	case 3: case 6: case 9:
	        		sb.append("R");
	        		rightCur = i;
	        		break;
	        	case 2: case 5: case 8: case 0:
	        		int dl = pos[i].dist(pos[leftCur]);
	        		int dr = pos[i].dist(pos[rightCur]);
	        		if (dl == dr) {
	        			if (isRH) { sb.append("R"); rightCur = i; }
	        			else { sb.append("L"); leftCur = i; }
	        		} else {
	        			if (dr < dl) { sb.append("R"); rightCur = i; }
	        			else { sb.append("L"); leftCur = i; }
	        		}
	        		break;
        	}
        }
        return sb.toString();
    }
}