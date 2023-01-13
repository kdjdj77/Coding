import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main {
	static class P {
		int x, y, c;
		boolean b;
		public P(int x, int y, int c, boolean b) {
			this.x = x; this.y = y; this.c = c; this.b = b;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] A = new char[N][M];
		boolean[][][] visit = new boolean[N][M][2];
		for(int i = 0; i < N; i++) A[i] = br.readLine().toCharArray();
		
		Queue<P> q = new LinkedList<>();
		q.add(new P(0, 0, 1, true));
		visit[0][0][0] = true;
		short[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
		while(!q.isEmpty()) {
			P cur = q.poll();
			if (cur.x == N-1 && cur.y == M-1) { System.out.print(cur.c); return; }
			for(int i = 0; i < 4; i++) {
				int x2 = cur.x + d[i][0], y2 = cur.y + d[i][1];
				if (x2 < 0 || y2 < 0 || x2 >= N || y2 >= M) continue;
				if(A[x2][y2] =='0') {
                    if (cur.b && !visit[x2][y2][0]) {
                        q.add(new P(x2, y2, cur.c+1, true));
                        visit[x2][y2][0] = true;
                    } else if (!cur.b && !visit[x2][y2][1]){
                        q.add(new P(x2, y2, cur.c+1, false));
                        visit[x2][y2][1] = true;
                    }
                } else {
                    if(cur.b){
                        q.add(new P(x2, y2, cur.c+1, false));
                        visit[x2][y2][1] = true;
                    }
                }
			}
		}
		System.out.print(-1);
	}
}