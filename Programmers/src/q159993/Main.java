package q159993;

class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] arr;
		
		arr = new String[] {
				"SOOOL",
				"XXXXO",
				"OOOOO",
				"OXXXX",
				"OOOOE"};
		print(s.solution(arr));
		
		arr = new String[] {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
		print(s.solution(arr));
	}
	private static void print(int o) {System.out.println("test");System.out.println(o);}
	private static void print(int[] arr) {System.out.println("test");for(Object o : arr) System.out.print(o + " ");System.out.println();}
	private static void print(int[][] arr) {System.out.println("test");for(int i = 0; i < arr.length; i++) {for(Object o : arr[i]) System.out.print(o + " ");System.out.println();}}
	private static void print(String o) {System.out.println("test");System.out.println(o); }
	private static void print(String[] arr) {System.out.println("test");for(Object o : arr) System.out.print(o + " ");System.out.println();}
	private static void print(String[][] arr) {System.out.println("test");for(int i = 0; i < arr.length; i++) { for(Object o : arr[i]) System.out.print(o + " ");System.out.println();}}
}