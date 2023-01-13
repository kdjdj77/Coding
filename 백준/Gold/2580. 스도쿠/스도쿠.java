import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	public static int[][] sudoku = new int[9][9];
	public static boolean isExit = false;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) sudoku[i][j] = Integer.parseInt(st.nextToken());
		}
		setSudoku(0, 0);
	}
	public static void setSudoku(int y, int x) {
		if (isExit) return;
		if (x == 9) { setSudoku(y + 1, 0); return; }
		if (y == 9) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) sb.append(sudoku[i][j]).append(' ');
				sb.append('\n');
			}
			System.out.println(sb);
			isExit = true;
		}
		else if (sudoku[y][x] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (valid(i, x, y)) {
					sudoku[y][x] = i;
					setSudoku(y, x + 1);
				}
			}
			sudoku[y][x] = 0;
			return;
		}
		else setSudoku(y, x + 1);
	}
	public static boolean valid(int num, int x, int y) {
		for (int i = 0; i < 9; i++) if (sudoku[y][i] == num) return false;
		for (int i = 0; i < 9; i++) if (sudoku[i][x] == num) return false;
		int y2 = (y / 3) * 3;
		int x2 = (x / 3) * 3;
 
		for (int i = y2; i < y2 + 3; i++)
			for (int j = x2; j < x2 + 3; j++)
				if (sudoku[i][j] == num) return false;
		return true;
	}
}