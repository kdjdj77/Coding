import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cnt = s.nextInt();
		for(int i = 0; i < cnt; i++) printIsPalindromeAndcount(s.next());
		s.close();
	}
	public static void printIsPalindromeAndcount(String str) {
		System.out.println(recursion(str, 0, str.length() - 1, 1));
	}
	public static String recursion(String s, int l, int r, int cnt){
	    if(l >= r) return 1 + " " + cnt;
	    else if(s.charAt(l) != s.charAt(r)) return 0 + " " + cnt;
	    else {
	    	cnt++;
	    	return recursion(s, l + 1, r - 1, cnt);
	    }
	}
}