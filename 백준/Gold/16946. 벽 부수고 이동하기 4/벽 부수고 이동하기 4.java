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