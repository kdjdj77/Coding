package q155651;

class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		
		String[][] arr = new String[][] {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
		System.out.println(s.solution(arr));
		
		arr = new String[][] {{"09:10", "10:10"}, {"10:20", "12:20"}};
		System.out.println(s.solution(arr));
		
		arr = new String[][] {{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}};
		System.out.println(s.solution(arr));
	}
}