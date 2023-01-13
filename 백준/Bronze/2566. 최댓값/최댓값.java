import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = 9, M = 9;
		int max = 0, row = 1, col = 1;
		int[][] list = new int[M][N];
		for(int i = 0; i < M; i++) for(int j = 0; j < N; j++) list[i][j] = s.nextInt();
		for(int i = 0; i < M; i++) for(int j = 0; j < N; j++) {
			if (list[i][j] > max) {
				max = list[i][j];
				row = i + 1; col = j + 1;
			}
		}
		System.out.println(max);
		System.out.println(row + " " + col);
		s.close();
	}
}