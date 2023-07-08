package q00_ETC.rank5pp.a14939;
/*
문제
전구 100개가 10×10 정사각형 모양으로 늘어서 있다. 전구에 달린 스위치를 누르면 그 전구와 위, 아래, 왼쪽, 오른쪽에 있는 전구의 상태도 바뀐다. 전구 100개의 상태가 주어지면 모든 전구를 끄기 위해 최소한으로 눌러야 하는 스위치의 개수를 출력하라

입력
10줄에 10글자씩 입력이 주어진다. #은 꺼진 전구고 O(대문자 알파벳 o)는 켜진 전구다. #과 O외에는 입력으로 주어지지 않는다.

출력
모든 전구를 끄기 위해 최소한으로 눌러야 하는 스위치의 개수를 출력하라. 불가능하면 -1를 출력하라.
*/

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