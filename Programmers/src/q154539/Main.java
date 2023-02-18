package q154539;

class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr;
		
		arr = new int[] {2, 3, 3, 5};
		print(s.solution(arr));
		arr = new int[] {9, 1, 5, 3, 6, 2};
		print(s.solution(arr));
	}
	private static void print(int o) {System.out.println("test");System.out.println(o);}
	private static void print(int[] arr) {System.out.println("test");for(Object o : arr) System.out.print(o + " ");System.out.println();}
	private static void print(int[][] arr) {System.out.println("test");for(int i = 0; i < arr.length; i++) {for(Object o : arr) System.out.print(o + " ");System.out.println();}}
	private static void print(String o) {System.out.println("test");System.out.println(o); }
	private static void print(String[] arr) {System.out.println("test");for(Object o : arr) System.out.print(o + " ");System.out.println();}
	private static void print(String[][] arr) {System.out.println("test");for(int i = 0; i < arr.length; i++) { for(Object o : arr) System.out.print(o + " ");System.out.println();}}
}