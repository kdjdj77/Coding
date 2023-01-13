import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cnt = Integer.parseInt(s.nextLine());
		
		String[] list = new String[cnt];
		for(int i = 0; i < cnt; i++) list[i] = s.nextLine();
		
		for(String a : list) {
			String[] scores = a.split(" ");
			String num = scores[0];
			int len = scores.length, sum = 0, p = 0;
			Double avg;
			
			for(int i = 1; i < len; i++) sum += Integer.parseInt(scores[i]);
			
			avg = sum / Double.parseDouble(num);
			
			for(int i = 1; i < len; i++) if(Integer.parseInt(scores[i]) > avg) p++;
			
			System.out.printf("%.3f%%\n", p * 100 / Double.parseDouble(num));
		}
		
		s.close();
	}
}