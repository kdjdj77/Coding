package q42577;

class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] arr = new String[] {"119", "97674223", "1195524421"};
		print(s.solution(arr));
		arr = new String[] {"123","456","789"};
		print(s.solution(arr));
		arr = new String[] {"12","123","1235","567","88"};
		print(s.solution(arr));
	}
	private static void print(boolean o) {System.out.println("test");System.out.println(o);}
}