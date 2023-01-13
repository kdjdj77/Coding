import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next(); s.close();
		int len = str.length(), res = 0;
		int num = Integer.parseInt(str);
		
		for(int i = num - len * 9; i < num; i++) {
			int a = i, sum = 0;
			while(a > 0) { sum += a % 10; a /= 10; }
			if(sum + i == num) { res = i; break; }
		}
		System.out.print(res);
	}
}