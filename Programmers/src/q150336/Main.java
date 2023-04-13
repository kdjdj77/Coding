package q150336;

class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] arr = new String[] {
			"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", 
			"UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", 
			"UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", 
			"UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", 
			"MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", 
			"UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"
		};
		print(s.solution(arr));
		arr = new String[] {
			"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", 
			"UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", 
			"MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"
		};
		print(s.solution(arr));
	}
	private static void print(int o) {System.out.println("test");System.out.println(o);}
	private static void print(int[] arr) {System.out.println("test");for(Object o : arr) System.out.print(o + " ");System.out.println();}
	private static void print(int[][] arr) {System.out.println("test");for(int i = 0; i < arr.length; i++) {for(Object o : arr[i]) System.out.print(o + " ");System.out.println();}}
	private static void print(String o) {System.out.println("test");System.out.println(o); }
	private static void print(String[] arr) {System.out.println("test");for(Object o : arr) System.out.print(o + " ");System.out.println();}
	private static void print(String[][] arr) {System.out.println("test");for(int i = 0; i < arr.length; i++) { for(Object o : arr[i]) System.out.print(o + " ");System.out.println();}}
}