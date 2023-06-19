import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] set, setOk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        set = new boolean[N][N]; setOk = new boolean[N][N];
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) setOk[i][j] = Integer.parseInt(st.nextToken()) == 1;
        }
        System.out.print(dfs(N, 0, 0) + dfs(N, 1, 0));
    }
    static int dfs(int N, int pos, int cnt) {
    	if (N % 2 == 0 && pos%N < 2) pos += pos%N == 0 ? 1 : -1;
    	if (pos >= N*N) return cnt;
        
    	int x = pos/N, y = pos%N, res = dfs(N, pos+2, cnt);
    	if (!isOk(N, x, y)) return res;
		set[x][y] = true;
    	res = Math.max(res, dfs(N, pos+2, cnt+1));
    	set[x][y] = false;
    	return res;
    }
    static boolean isOk(int N, int x, int y) {
    	if (!setOk[x][y]) return false;
    	for(int i = x-1, j = y-1; i >= 0 && j >= 0; i--, j--) if (set[i][j]) return false;
    	for(int i = x-1, j = y+1; i >= 0 && j < N; i--, j++) if (set[i][j]) return false;
    	return true;
    }
}