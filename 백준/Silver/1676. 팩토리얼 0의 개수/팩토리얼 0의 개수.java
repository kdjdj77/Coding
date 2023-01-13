import java.util.Scanner;

public class Main {
	static int m2 = 0, m5 = 0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        for(int i = 1; i <= num; i++) add2or5(i);
        System.out.println(Math.min(m2, m5));
        s.close();
    }
    public static void add2or5(int num) {
    	if (num % 2 == 0) { num /= 2; m2++; }
    	else if (num % 5 == 0) { num /= 5; m5++; }
    	else return;
    	add2or5(num);
    }
}