import java.io.*;
import java.util.*;

public class Main {
	static int N, P, dp[], pp[][];
    static final int INF = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        pp = new int[N][N];
        dp = new int[1<<N];

        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) pp[i][j] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, -1);

        int visit = 0, on = 0;
        String YN = br.readLine();
        for (int x = 0; x < N; x++) if (YN.charAt(x) == 'Y') { visit |= 1 << x; on++; }

        P = Integer.parseInt(br.readLine());

        int res = repair(visit, on);
        if (res == INF) res = -1;

        System.out.print(res);
    }

    public static int repair(int visit, int on) {
        if (on >= P) return 0;
        if (dp[visit] != -1) return dp[visit];

        int res = INF;
        for (int i = 0; i < N; i++) {
            if ((visit & (1 << i)) != 0) continue;
            
            int min = INF;
            for (int j = 0; j < N; j++) {
                if ((visit & (1 << j)) == 0) continue;
                min = Math.min(min, pp[j][i]);
            }
            res = Math.min(res, repair((visit | (1 << i)), on + 1) + min);
        }
        return dp[visit] = res;
    }
}