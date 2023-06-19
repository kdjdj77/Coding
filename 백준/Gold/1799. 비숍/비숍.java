import java.io.*;
import java.util.*;

public class Main {
	static int N, map[][];
	static boolean even, set[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N]; set = new boolean[N][N]; even = N % 2 == 0;
        for(int i = 0; i < N; i++)
        	map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.print(dfs(0, 0) + dfs(1, 0));
    }
    static int dfs(int pos, int cnt) {
    	if (even) if (pos%N == 0) pos++; else if(pos%N == 1) pos--;
    	if (pos >= N*N) return cnt;
        
    	int x = pos/N, y = pos%N, res = dfs(pos+2, cnt);
    	if (!isOk(x, y)) return res;
		set[x][y] = true;
    	res = Math.max(res, dfs(pos+2, cnt+1));
    	set[x][y] = false;
    	return res;
    }
    static boolean isOk(int x, int y) {
    	if (map[x][y] == 0) return false;
    	for(int i = x-1, j = y-1; i >= 0 && j >= 0; i--, j--) if (set[i][j]) return false;
    	for(int i = x-1, j = y+1; i >= 0 && j < N; i--, j++) if (set[i][j]) return false;
    	return true;
    }
}