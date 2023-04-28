package q86971;

import a출력객체.P;

class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		P p = new P();
		p.print(s.solution(9,new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
		p.print(s.solution(4,new int[][]{{1,2},{2,3},{3,4}}));
		p.print(s.solution(7,new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}));
	}
}