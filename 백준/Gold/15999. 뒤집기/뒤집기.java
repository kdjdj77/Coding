import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
	    int dy[] = {-1, 1, 0, 0}, dx[] = {0, 0, -1, 1}, MOD = 1000000007, cnt = 0;
	    char[][] adj = new char[N][M];
	    for(int i = 0; i < N; i++) adj[i] = br.readLine().toCharArray();
	    for(int i = 0; i < N; i++) for(int j = 0; j < M; j++) for(int k = 0; k < 4; k++) {
            int ny = i + dy[k], nx = j + dx[k];
            if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
            if (adj[i][j] != adj[ny][nx]) {cnt++; break;}
	    }
	    int res = 1;
	    for(int i = 0; i < N*M-cnt; i++) res = (res*2)%MOD;
	    System.out.print(res);
	}
}