import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Double R = s.nextDouble();
		System.out.printf("%.6f\n", Math.PI * R * R);
		System.out.printf("%.6f", R * R * 2);
		s.close();
	}
}