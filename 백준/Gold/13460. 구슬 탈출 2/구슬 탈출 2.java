import java.io.*;
import java.util.*;

class Save {
	int cnt, before, R[], B[];
	public Save(int cnt, int before, int[] r, int[] b) {
		this.cnt = cnt;
		this.before = before;
		this.R = r;
		this.B = b;
	}
}
public class Main {
	private static char[][] board;
	private static int N, M, R[], B[], d[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for(int i = 0; i < N; i++) {
        	String str = br.readLine();
        	for(int j = 0; j < M; j++) {
        		board[i][j] = str.charAt(j);
        		if (board[i][j] == 'R') R = new int[] {i, j};
        		else if (board[i][j] == 'B') B = new int[] {i, j};
        	}
        }
        System.out.print(bfs(new Save(1, -1, R.clone(), B.clone())));
    }
    private static int bfs(Save start) {
    	Queue<Save> q = new LinkedList<>();
    	q.add(start);
    	int res = -1;
    	while(!q.isEmpty()) {
    		Save cur = q.poll();
    		int pass = cur.before, cnt = cur.cnt, r[] = cur.R, b[] = cur.B;
    		if (cnt > 10) break;
        	for(int i = 0; i < 4; i++) {
        		if (pass != -1) if (i == pass || i == (pass+2)%4) continue;
        		R = r.clone(); B = b.clone();
        		int stat = move(i, cnt);
        		if (stat == -1) continue;
        		if (stat == 1) return cnt;
        		q.add(new Save(cnt+1, i, R.clone(), B.clone()));
        	}
    	}
    	return res;
    }
	private static int move(int dir, int cnt) {
		int total = 0, move = 1, m[] = d[dir];
    	boolean ro = false, bo = false;
		while(move != 0) {
    		move = 0;
    		char rm = board[R[0]+m[0]][R[1]+m[1]], bm = board[B[0]+m[0]][B[1]+m[1]];
    		int[] rp = {R[0]+m[0], R[1]+m[1]}, bp = {B[0]+m[0], B[1]+m[1]};
			if (rm != '#' && !Arrays.equals(rp, B)) {
    			R[0] += m[0]; R[1] += m[1];
    			total++; move++;
    		} if (rm == 'O') ro = true;
			if (bm != '#' && !Arrays.equals(bp, R)) {
    			B[0] += m[0]; B[1] += m[1];
    			total++; move++;
    		} if (bm == 'O') bo = true;
    	}
		if (total == 0 || bo) return -1;
		if (ro) return 1;
    	return 0;
	}
}