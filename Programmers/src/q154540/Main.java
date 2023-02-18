package q154540;

class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		String arr[];
		
		arr = new String[] {"X591X","X1X5X","X231X", "1XXX1"};
		print(s.solution(arr));
		
		arr = new String[] {"XXX","XXX","XXX"};
		print(s.solution(arr));
	}
	private static void print(int[] arr) {
		for(int a : arr) System.out.print(a + " ");
		System.out.println();
	}
}