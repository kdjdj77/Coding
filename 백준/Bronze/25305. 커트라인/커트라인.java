import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt(); 
		int k = s.nextInt();
		int[] list = new int[N];
		for(int i = 0; i < N; i++) list[i] = s.nextInt();
		s.close();
		
		printCutLine(list, N, k);
	}
	public static void printCutLine(int[] list, int N, int k) {
		for(int i = 0; i < k; i++) {
			int max = list[i]; int index = i;
			for(int j = i + 1; j < N; j++)
				if (list[j] > max) { max = list[j]; index = j; }

			list[index] = list[i];
			list[i] = max;
		}
		System.out.println(list[k - 1]);
	}
}