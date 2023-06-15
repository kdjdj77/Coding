package q00_ETC.rank5p.a2239;
/*
문제
스도쿠는 매우 간단한 숫자 퍼즐이다. 9×9 크기의 보드가 있을 때, 각 행과 각 열, 그리고 9개의 3×3 크기의 보드에 1부터 9까지의 숫자가 중복 없이 나타나도록 보드를 채우면 된다. 예를 들어 다음을 보자.



위 그림은 참 잘도 스도쿠 퍼즐을 푼 경우이다. 각 행에 1부터 9까지의 숫자가 중복 없이 나오고, 각 열에 1부터 9까지의 숫자가 중복 없이 나오고, 각 3×3짜리 사각형(9개이며, 위에서 색깔로 표시되었다)에 1부터 9까지의 숫자가 중복 없이 나오기 때문이다.

하다 만 스도쿠 퍼즐이 주어졌을 때, 마저 끝내는 프로그램을 작성하시오.

입력
9개의 줄에 9개의 숫자로 보드가 입력된다. 아직 숫자가 채워지지 않은 칸에는 0이 주어진다.

출력
9개의 줄에 9개의 숫자로 답을 출력한다. 답이 여러 개 있다면 그 중 사전식으로 앞서는 것을 출력한다. 즉, 81자리의 수가 제일 작은 경우를 출력한다.
*/

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