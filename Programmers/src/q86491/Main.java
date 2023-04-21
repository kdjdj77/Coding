package q86491;

class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] arr = new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		print(s.solution(arr));
		arr = new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
		print(s.solution(arr));
		arr = new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
		print(s.solution(arr));
	}
	private static void print(int o) {System.out.println("test");System.out.println(o);}
	private static void print(int[] arr) {System.out.println("test");for(Object o : arr) System.out.print(o + " ");System.out.println();}
	private static void print(int[][] arr) {System.out.println("test");for(int i = 0; i < arr.length; i++) {for(Object o : arr[i]) System.out.print(o + " ");System.out.println();}}
	private static void print(String o) {System.out.println("test");System.out.println(o); }
	private static void print(String[] arr) {System.out.println("test");for(Object o : arr) System.out.print(o + " ");System.out.println();}
	private static void print(String[][] arr) {System.out.println("test");for(int i = 0; i < arr.length; i++) { for(Object o : arr[i]) System.out.print(o + " ");System.out.println();}}
}