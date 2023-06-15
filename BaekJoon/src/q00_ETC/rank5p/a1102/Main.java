package q00_ETC.rank5p.a1102;
/*
문제
은진이는 발전소에서 근무한다. 은진이가 회사에서 잠깐 잘 때마다, 몇몇 발전소가 고장이난다. 게다가, 지금 은진이의 보스 형택이가 은진이의 사무실로 걸어오고 있다. 만약 은진이가 형택이가 들어오기 전까지 발전소를 고쳐놓지 못한다면, 은진이는 해고당할 것이다.

발전소를 고치는 방법은 간단하다. 고장나지 않은 발전소를 이용해서 고장난 발전소를 재시작하면 된다. 하지만, 이때 비용이 발생한다. 이 비용은 어떤 발전소에서 어떤 발전소를 재시작하느냐에 따라 다르다.

적어도 P개의 발전소가 고장나 있지 않도록, 발전소를 고치는 비용의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 발전소의 개수 N이 주어진다. N은 16보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 발전소 i를 이용해서 발전소 j를 재시작할 때 드는 비용이 주어진다. i줄의 j번째 값이 그 값이다. 그 다음 줄에는 각 발전소가 켜져있으면 Y, 꺼져있으면 N이 순서대로 주어진다. 마지막 줄에는 P가 주어진다. 비용은 36보다 작거나 같은 음이 아닌 정수이고, P는 0보다 크거나 같고, N보다 작거나 같은 정수이다.

출력
첫째 줄에 문제의 정답을 출력한다. 불가능한 경우에는 -1을 출력한다.
*/

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