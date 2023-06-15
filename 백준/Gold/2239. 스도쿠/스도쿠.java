import java.io.*;
import java.util.*;

public class Main {
	private static int[][] sdk;
	private static boolean stop;
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sdk = new int[9][9];
		for(int i = 0; i < 9; i++)
			sdk[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		fill(0);
		for(int[] s : sdk) { for(int x : s) sb.append(x); sb.append("\n"); }
		System.out.print(sb);
	}
	private static void fill(int t) {
		if (t == 81) {stop = true; return;}
		
		int x = t/9, y = t%9;
		if (sdk[x][y] != 0) {fill(t+1); return;}
		for(int num = 1; num <= 9; num++) {
			if (!isValid(x, y, num)) continue;
			sdk[x][y] = num;
			fill(t+1);
			if (stop) return;
			sdk[x][y] = 0;
		}
	}
	private static boolean isValid(int x, int y, int n) {
		int x0 = x/3*3, y0 = y/3*3;
		for(int i = 0; i < 9; i++) if (sdk[i][y] == n || sdk[x][i] == n) return false;
		for(int i = 0; i < 9; i++) if (sdk[x0+i/3][y0+i%3] == n) return false;
		return true;
	}
}