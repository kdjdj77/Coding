import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int min = s.nextInt();
		int max = s.nextInt();
		
		for(int i = min; i <= max; i++)
			if (isPrime(i)) System.out.println(i);
		s.close();
	}
	public static boolean isPrime(int a) {
		if (a == 1) return false;
		for(int i = 2; i <= Math.sqrt(a); i++)
			if (a % i == 0) return false;
		return true;
	}
}