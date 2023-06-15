package q00_ETC.rank5p.a2357;
/*
문제
N(1 ≤ N ≤ 100,000)개의 정수들이 있을 때, a번째 정수부터 b번째 정수까지 중에서 제일 작은 정수, 또는 제일 큰 정수를 찾는 것은 어려운 일이 아니다. 하지만 이와 같은 a, b의 쌍이 M(1 ≤ M ≤ 100,000)개 주어졌을 때는 어려운 문제가 된다. 이 문제를 해결해 보자.

여기서 a번째라는 것은 입력되는 순서로 a번째라는 이야기이다. 예를 들어 a=1, b=3이라면 입력된 순서대로 1번, 2번, 3번 정수 중에서 최소, 최댓값을 찾아야 한다. 각각의 정수들은 1이상 1,000,000,000이하의 값을 갖는다.

입력
첫째 줄에 N, M이 주어진다. 다음 N개의 줄에는 N개의 정수가 주어진다. 다음 M개의 줄에는 a, b의 쌍이 주어진다.

출력
M개의 줄에 입력받은 순서대로 각 a, b에 대한 답을 최솟값, 최댓값 순서로 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	private static int in[], seg[][], INF = 1234567890;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        in = new int[N];
        for(int i = 0; i < N; i++) in[i] = Integer.parseInt(br.readLine());
        
        seg = new int[2][(int)Math.pow(2, Math.ceil(Math.log(N)/Math.log(2))+1)];
        Arrays.fill(seg[0], INF);
        set(1, 0, N-1, 0); set(1, 0, N-1, 1);
        
        while(M-- > 0) {
        	st = new StringTokenizer(br.readLine());
        	int l = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
        	sb.append(res(1, 0, N-1, --l, --r, 0)).append(" ").append(res(1, 0, N-1, l, r, 1)).append("\n");
        }
        System.out.print(sb);
    }
    private static int set(int rt, int s, int e, int z) {
    	if (s == e) return seg[z][rt] = in[s];
        int m = (s+e)/2, n1 = set(rt*2, s, m, z), n2 = set(rt*2+1, m+1, e, z);
        return seg[z][rt] = z == 0 ? Math.min(n1, n2) : Math.max(n1, n2);
    }
    private static int res(int rt, int s, int e, int l, int r, int z) {
        if (e < l || r < s) return z == 0 ? INF : 0;
        if (l <= s && e <= r) return seg[z][rt];
        int m = (s+e)/2, n1 = res(rt*2, s, m, l, r, z), n2 = res(rt*2 + 1, m + 1, e, l, r, z);
        return z == 0 ? Math.min(n1, n2) : Math.max(n1, n2);
    }
}