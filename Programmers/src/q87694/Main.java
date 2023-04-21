package q87694;

class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		
		print(s.solution(new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}},1,3,7,8));
		print(s.solution(new int[][]{{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}},9,7,6,1));
		print(s.solution(new int[][]{{1,1,5,7}},1,1,4,7));
		print(s.solution(new int[][]{{2,1,7,5},{6,4,10,10}},3,1,7,10));
		print(s.solution(new int[][]{{2,2,5,5},{1,3,6,4},{3,1,4,6}},1,4,6,3));
	}
	private static void print(int o) {System.out.println("test");System.out.println(o);}
	private static void print(int[] arr) {System.out.println("test");for(Object o : arr) System.out.print(o + " ");System.out.println();}
	private static void print(int[][] arr) {System.out.println("test");for(int i = 0; i < arr.length; i++) {for(Object o : arr[i]) System.out.print(o + " ");System.out.println();}}
	private static void print(String o) {System.out.println("test");System.out.println(o); }
	private static void print(String[] arr) {System.out.println("test");for(Object o : arr) System.out.print(o + " ");System.out.println();}
	private static void print(String[][] arr) {System.out.println("test");for(int i = 0; i < arr.length; i++) { for(Object o : arr[i]) System.out.print(o + " ");System.out.println();}}
}