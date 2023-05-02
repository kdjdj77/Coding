package q1843;

import a출력객체.P;

class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		P p = new P();
		p.print(s.solution(new String[] {"1", "-", "3", "+", "5", "-", "8"}));
		p.print(s.solution(new String[] {"5", "-", "3", "+", "1", "+", "2", "-", "4"}));
	}
}