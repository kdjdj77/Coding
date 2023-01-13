import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int h = s.nextInt();
		int m = s.nextInt();
		
		m -= 45;
		if (m < 0) { m += 60; h -= 1; }
		if (h < 0) { h += 24; }
		System.out.print(h + " " + m);
		
		s.close();
	}
}