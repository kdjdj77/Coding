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
		for(int i = 0, num = 1; i < N; i++) for(int j = 0; j < M; j++)
			if (map[i][j] == -1) set.put(num, dfs(i, j, num++));
		
		for(int i = 0; i < N; i++, sb.append("\n")) for(int j = 0; j < M; j++) sb.append(res(i, j));
		System.out.print(sb);
	}
	static int res(int x, int y) {
		if (map[x][y] != 0) return 0;
		int res = 1;
		Set<Integer> nearby = new HashSet<>();
		for(int d[] : dir) {
			int x1 = x+d[0], y1 = y+d[1];
			if (x1 < 0 || y1 < 0 || x1 >= N || y1 >= M || map[x1][y1] == 0) continue;
			nearby.add(map[x1][y1]);
		}
		for(int num : nearby) res += set.get(num);
		return res % 10;
	}
	static int dfs(int x, int y, int num) {
		int res = 1;
		map[x][y] = num;
		for(int[] d : dir) {
			int x1 = x+d[0], y1 = y+d[1];
			if (x1 < 0 || y1 < 0 || x1 >= N || y1 >= M) continue;
			if (map[x1][y1] != -1) continue;
			res += dfs(x1, y1, num);
		}
		return res;
	}
}