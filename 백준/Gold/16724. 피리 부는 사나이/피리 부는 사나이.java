import java.io.*;
import java.util.*;

public class Main {
	static char c, map[][];
	static Map<Character, Integer> dir;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), res = 0;
		map = new char[N][M];
		dir = Map.of('U', -10,'D', 10,'L', -1,'R', 1);
		for(int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();
		for(int d = 0, k = 1; d < N*M; d++) res += dfs(d/M, d%M, k++);
		System.out.print(res);
	}
	static int dfs(int x, int y, int k) {
		if ((c = map[x][y]) < 2) return map[x][y] == 1 ? 1 : 0;
		map[x][y] = 1;
		int d = dir.get(c), res = dfs(x+d/10, y+d%10, k);
		map[x][y] = 0;
		return res;
	}
}