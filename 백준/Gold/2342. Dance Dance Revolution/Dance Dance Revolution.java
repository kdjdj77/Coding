import java.io.*;
import java.util.*;

public class Main {
	static int N, cmd[], dp[][][];
	static int[][] move = {{1,2,2,2,2},{2,1,3,4,3},{2,3,1,3,4},{2,4,3,1,3},{2,3,4,3,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cmd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new int[5][5][N = cmd.length-1];
        System.out.println(res(0, 0, 0)-1);
    }
    static int res(int idx, int l, int r) {
		if(idx == N) return 1;
		if(dp[l][r][idx] != 0) return dp[l][r][idx];
		int lp = move[l][cmd[idx]] + res(idx+1, cmd[idx], r);
		int rp = move[r][cmd[idx]] + res(idx+1, l, cmd[idx]);
		return dp[l][r][idx] = Math.min(lp, rp);
	}
}