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