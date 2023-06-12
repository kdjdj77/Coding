import java.io.*;
import java.util.*;

public class Main {
    static int N, res, board[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i = 0; i < N; i++)
        	board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dfs(res = 0);
        System.out.print(res);
    }
    private static void dfs(int depth) {
        if (depth == 5) {max(); return;}
        int copy[][] = new int[N][N];
        for(int i = 0; i < N; i++) copy[i] = board[i].clone();
        for(int dir = 0; dir < 4; dir++) {
            move(dir);
            dfs(depth+1);
            for(int i = 0; i < N; i++) board[i] = copy[i].clone();
        }
    }
    private static void move(int dir) {
    	boolean f1 = dir < 2, f2 = dir%2 == 0;
        for(int i = 0; i < N; i++) {
            int idx = f2 ? 0 : N-1, cur = 0;
            for(int j = f2?0:N-1; f2?j<N:j>=0; j += f2?1:-1) {
            	int tmp = board[f1 ? j : i][f1 ? i : j];
            	if (tmp == 0) continue;
            	board[f1 ? j : i][f1 ? i : j] = 0;
                if (cur == tmp) {
                	int[] p1 = {idx-1,idx+1,i,i}, p2 = {i,i,idx-1,idx+1};
                	board[p1[dir]][p2[dir]] = cur*2;
                	cur = 0;
                } else switch(dir) {
                	case 0: board[idx++][i] = cur = tmp; break;
                	case 1: board[idx--][i] = cur = tmp; break;
                	case 2: board[i][idx++] = cur = tmp; break;
                	case 3: board[i][idx--] = cur = tmp; break;
            	}
            }
        }
    }
    private static void max() {
        for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) res = Math.max(res, board[i][j]);
    }
}