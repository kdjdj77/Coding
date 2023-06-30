package q00_ETC.rank5pp.a16946;
/*
문제
N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 한 칸에서 다른 칸으로 이동하려면, 두 칸이 인접해야 한다. 두 칸이 변을 공유할 때, 인접하다고 한다.

각각의 벽에 대해서 다음을 구해보려고 한다.

벽을 부수고 이동할 수 있는 곳으로 변경한다.
그 위치에서 이동할 수 있는 칸의 개수를 세어본다.
한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.

입력
첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다.

출력
맵의 형태로 정답을 출력한다. 원래 빈 칸인 곳은 0을 출력하고, 벽인 곳은 이동할 수 있는 칸의 개수를 10으로 나눈 나머지를 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, map[][], dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static Map<Integer,Integer> set;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		map = new int[N = Integer.parseInt(st.nextToken())][M = Integer.parseInt(st.nextToken())];
		for(int i = 0; i < N; i++, br.readLine()) for(int j = 0; j < M; j++) map[i][j] = br.read()-49;
		set = new HashMap<>();
		for(int i = 0, num = 1; i < N*M; i++) if (map[i/M][i%M] == -1) set.put(num, dfs(i/M, i%M, num++));
		for(int i = 0; i < N; i++, sb.append("\n")) for(int j = 0; j < M; j++) sb.append(res(i, j));
		System.out.print(sb);
	}
	static boolean isValid(int x, int y) {return x >= 0 && y >= 0 && x < N && y < M;}
	static int dfs(int x, int y, int num) {
		int x1, y1, res = 1;
		map[x][y] = num;
		for(int[] d : dir) if (isValid(x1=x+d[0], y1=y+d[1]) && map[x1][y1] == -1) res += dfs(x1, y1, num);
		return res;
	}
	static int res(int x, int y) {
		if (map[x][y] != 0) return 0;
		int x1, y1, res = 1;
		Set<Integer> nearby = new HashSet<>();
		for(int d[] : dir) if (isValid(x1=x+d[0], y1=y+d[1]) && map[x1][y1] != 0) nearby.add(map[x1][y1]);
		for(int num : nearby) res += set.get(num);
		return res % 10;
	}
}