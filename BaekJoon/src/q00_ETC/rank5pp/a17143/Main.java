package q00_ETC.rank5pp.a17143;
/*
문제
낚시왕이 상어 낚시를 하는 곳은 크기가 R×C인 격자판으로 나타낼 수 있다. 격자판의 각 칸은 (r, c)로 나타낼 수 있다. r은 행, c는 열이고, (R, C)는 아래 그림에서 가장 오른쪽 아래에 있는 칸이다. 칸에는 상어가 최대 한 마리 들어있을 수 있다. 상어는 크기와 속도를 가지고 있다.



낚시왕은 처음에 1번 열의 한 칸 왼쪽에 있다. 다음은 1초 동안 일어나는 일이며, 아래 적힌 순서대로 일어난다. 낚시왕은 가장 오른쪽 열의 오른쪽 칸에 이동하면 이동을 멈춘다.

낚시왕이 오른쪽으로 한 칸 이동한다.
낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
상어가 이동한다.
상어는 입력으로 주어진 속도로 이동하고, 속도의 단위는 칸/초이다. 상어가 이동하려고 하는 칸이 격자판의 경계를 넘는 경우에는 방향을 반대로 바꿔서 속력을 유지한채로 이동한다.

왼쪽 그림의 상태에서 1초가 지나면 오른쪽 상태가 된다. 상어가 보고 있는 방향이 속도의 방향, 왼쪽 아래에 적힌 정수는 속력이다. 왼쪽 위에 상어를 구분하기 위해 문자를 적었다.



상어가 이동을 마친 후에 한 칸에 상어가 두 마리 이상 있을 수 있다. 이때는 크기가 가장 큰 상어가 나머지 상어를 모두 잡아먹는다.

낚시왕이 상어 낚시를 하는 격자판의 상태가 주어졌을 때, 낚시왕이 잡은 상어 크기의 합을 구해보자.

입력
첫째 줄에 격자판의 크기 R, C와 상어의 수 M이 주어진다. (2 ≤ R, C ≤ 100, 0 ≤ M ≤ R×C)

둘째 줄부터 M개의 줄에 상어의 정보가 주어진다. 상어의 정보는 다섯 정수 r, c, s, d, z (1 ≤ r ≤ R, 1 ≤ c ≤ C, 0 ≤ s ≤ 1000, 1 ≤ d ≤ 4, 1 ≤ z ≤ 10000) 로 이루어져 있다. (r, c)는 상어의 위치, s는 속력, d는 이동 방향, z는 크기이다. d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 의미한다.

두 상어가 같은 크기를 갖는 경우는 없고, 하나의 칸에 둘 이상의 상어가 있는 경우는 없다.

출력
낚시왕이 잡은 상어 크기의 합을 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	static int R, C, M, map[][], res = 0, dir[][] = {{0,0},{-1,0},{1,0},{0,1},{0,-1}}, re[] = {0,2,1,4,3};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Shark[] shark;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = in(); C = in(); M = in(); shark = new Shark[M+1]; map = new int[R][C];
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = in()-1, c = in()-1, s = in(), d = in(), z = in();
			shark[i] = new Shark(r, c, d < 3 ? s%((R-1)*2) : s%((C-1)*2), d, z);
			map[r][c] = i;
		}
		for(int i = 0; i < C; i++) turn(i);
		System.out.print(res);
	}
	static class Shark {
		int x, y, speed, dir, size;
		Shark(int r, int c, int s, int d, int z) {x = r; y = c; speed = s; dir = d; size = z;}
	}
	static int in() {return Integer.parseInt(st.nextToken());}
	static void turn(int pos) {
		for(int i = 0, sharkId; i < R; i++) if ((sharkId = map[i][pos]) != 0) {
			res += shark[sharkId].size;
			shark[sharkId] = null;
			break;
		}
		map = new int[R][C];
		for(int i = 1, exist; i <= M; i++) {
			Shark cur = shark[i];
			if (cur == null) continue;
			int d[] = dir[cur.dir], x1 = cur.x+d[0]*cur.speed, y1 = cur.y+d[1]*cur.speed;
			if (cur.dir < 3) while(x1 < 0 || x1 >= R) {
				x1 = x1 < 0 ? -x1 : (R-1)*2-x1;
				d = dir[cur.dir = re[cur.dir]];
			} else while(y1 < 0 || y1 >= C) {
				y1 = y1 < 0 ? -y1 : (C-1)*2-y1;
				d = dir[cur.dir = re[cur.dir]];
			}
			cur.x = x1; cur.y = y1;
			shark[i] = cur;
			if ((exist = map[x1][y1]) != 0 && shark[exist].size > cur.size) shark[i] = null;
			else {shark[exist] = null; map[x1][y1] = i;}
		}
	}
}