package q42579;

class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] genre = new String[] {"classic", "pop", "classic", "classic", "pop"};
		int[] arr = new int[] {500, 600, 150, 800, 2500};
		print(s.solution(genre, arr));
	}
	private static void print(int o) {System.out.println("test");System.out.println(o);}
	private static void print(int[] arr) {System.out.println("test");for(Object o : arr) System.out.print(o + " ");System.out.println();}
	private static void print(int[][] arr) {System.out.println("test");for(int i = 0; i < arr.length; i++) {for(Object o : arr[i]) System.out.print(o + " ");System.out.println();}}
	private static void print(String o) {System.out.println("test");System.out.println(o); }
	private static void print(String[] arr) {System.out.println("test");for(Object o : arr) System.out.print(o + " ");System.out.println();}
	private static void print(String[][] arr) {System.out.println("test");for(int i = 0; i < arr.length; i++) { for(Object o : arr[i]) System.out.print(o + " ");System.out.println();}}
}