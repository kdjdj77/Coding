package q42578;

class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		String[][] arr = new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		print(s.solution(arr));
		arr = new String[][] {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		print(s.solution(arr));
	}
	private static void print(int o) {System.out.println("test");System.out.println(o);}
	private static void print(int[] arr) {System.out.println("test");for(Object o : arr) System.out.print(o + " ");System.out.println();}
	private static void print(int[][] arr) {System.out.println("test");for(int i = 0; i < arr.length; i++) {for(Object o : arr[i]) System.out.print(o + " ");System.out.println();}}
	private static void print(String o) {System.out.println("test");System.out.println(o); }
	private static void print(String[] arr) {System.out.println("test");for(Object o : arr) System.out.print(o + " ");System.out.println();}
	private static void print(String[][] arr) {System.out.println("test");for(int i = 0; i < arr.length; i++) { for(Object o : arr[i]) System.out.print(o + " ");System.out.println();}}
}