import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int cnt = s.nextInt();
		
		for(int i = 0; i < cnt; i++) {
			int repeat = s.nextInt();
			String test = s.next();
			for(int j = 0; j < test.length(); j++)
				for(int k = 0; k < repeat; k++)
					System.out.print(test.charAt(j));
			System.out.println();
		}
		
		s.close();
	}
}