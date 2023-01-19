import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int melon = s.nextInt();
		
		int[] list = new int[6];
		for (int i = 0; i < 6; i++) { s.next(); list[i] = s.nextInt(); }
		int area = 0, myArea = 0;
		for (int i = 0; i < 6; i++) {
			int tmp = list[i] * list[i == 5 ? 0 : i + 1];
			if (tmp > area) area = tmp;
			myArea += tmp;
		}
		System.out.println(melon * (myArea - 2 * area));
		s.close();
	}
}