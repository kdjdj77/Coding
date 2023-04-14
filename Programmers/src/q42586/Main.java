package q42586;

class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr1 = new int[] {93, 30, 55};
		int[] arr2 = new int[] {1, 30, 5};
		print(s.solution(arr1, arr2));
		arr1 = new int[] {95, 90, 99, 99, 80, 99};
		arr2 = new int[] {1, 1, 1, 1, 1, 1};
		print(s.solution(arr1, arr2));
	}
	private static void print(int o) {System.out.println("test");System.out.println(o);}
	private static void print(int[] arr) {System.out.println("test");for(Object o : arr) System.out.print(o + " ");System.out.println();}
	private static void print(int[][] arr) {System.out.println("test");for(int i = 0; i < arr.length; i++) {for(Object o : arr[i]) System.out.print(o + " ");System.out.println();}}
	private static void print(String o) {System.out.println("test");System.out.println(o); }
	private static void print(String[] arr) {System.out.println("test");for(Object o : arr) System.out.print(o + " ");System.out.println();}
	private static void print(String[][] arr) {System.out.println("test");for(int i = 0; i < arr.length; i++) { for(Object o : arr[i]) System.out.print(o + " ");System.out.println();}}
}