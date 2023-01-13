public class Main {
	public static void main(String[] args) {
		boolean[] list = new boolean[10001];
		for(int i = 1; i < 10001; i++) if (d(i) < 10001) list[d(i)] = true;
		for(int i = 1; i < 10001; i++) if(!list[i]) System.out.println(i);
	}
	
	public static int d(int a) {
		int sum = a;
		while(a != 0) {
			sum += a % 10;
			a = a / 10;
		}
		return sum;
	}
}