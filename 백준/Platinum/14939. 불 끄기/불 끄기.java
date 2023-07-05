import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[][] bulb = new boolean[10][10], dup = new boolean[10][10];
	static int bit = 1 << 10, dir[][] = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		int res = Integer.MAX_VALUE;
		for(int i = 0; i < 10; i++, br.readLine()) for(int j = 0; j < 10; j++)
			bulb[i][j] = br.read() == 'O' ? true : false;
		
		for(int i = 0, sum = 0, tmp = 0; i < bit; i++, sum = 0, tmp = 0) {
			for(int j = 0; j < 10; j++) dup[j] = bulb[j].clone();
			for(int j = 1, n = bit; j <= 10; j++) if ((i&(n>>j)) > 0) tmp += turn(0, j-1);
			for(int j = 1; j < 10; j++) for(int k = 0; k < 10; k++) if (dup[j-1][k]) tmp += turn(j, k);
			for(boolean b : dup[9]) if (b) sum++;
			if (sum == 0) res = Math.min(res, tmp);
		}
		System.out.print(res == Integer.MAX_VALUE ? "-1" : res);
	}
	static int turn(int x, int y) {
		for(int[] d : dir) {
			int x2 = x+d[0], y2 = y+d[1];
			if (x2 < 0 || y2 < 0 || x2 >= 10 || y2 >= 10) continue;
			dup[x2][y2] = !dup[x2][y2];
		} return 1;
	}
}