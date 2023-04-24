package q84021;

import a출력객체.P;

class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		P p = new P();
		int[][] a1, a2;
		a1 = new int[][] {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
		a2 = new int[][] {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
		p.print(s.solution(a1, a2));
		a1 = new int[][] {{0,0,0},{1,1,0},{1,1,1}};
		a2 = new int[][] {{1,1,1},{1,0,0},{0,0,0}};
		p.print(s.solution(a1, a2));
	}
}