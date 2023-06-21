import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static int[][] visit;
	static Map<Character, int[]> dir;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), res = 0;
		map = new char[N][M];
		visit = new int[N][M];
		dir = Map.of('U', new int[] {-1, 0},'D', new int[] {1, 0},'L', new int[] {0, -1},'R', new int[] {0, 1});
		for(int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();
		for(int d = 0, k = 1; d < N*M; d++) if (visit[d/M][d%M] == 0) res += dfs(d/M, d%M, k++);
		System.out.print(res);
	}
	static int dfs(int x, int y, int k) {
		if (visit[x][y] != 0) return visit[x][y] == k ? 1 : 0;
		visit[x][y] = k;
		int[] d = dir.get(map[x][y]);
		return dfs(x+d[0], y+d[1], k);
	}
}