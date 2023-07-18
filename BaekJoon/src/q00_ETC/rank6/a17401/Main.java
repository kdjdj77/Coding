package q00_ETC.rank6.a17401;
/*
문제
사람의 세포 수, 약 37조 개. 세포들은 몸 속에서 오늘도 열심히 일하고 있다. 그중에서도 우리의 적혈구는 혈관을 타고 돌아다니며 산소와 영양소를 운반해주는 중요한 역할을 맡고있다.

적혈구는 심장이나 폐 같은 거점들을 돌아다니면서 산소와 영양분을 운반한다. 몸 속에는 총 N개의 거점이 있고, 몇몇 거점은 통로를 통해 서로 이어져 있다. 거점 사이의 통로를 통과하는데는 1초가 걸린다. 하지만 혈관의 곳곳에는 판막이나 공사중인 부분들이 있기 때문에 매 초 거점 사이의 연결관계가 바뀐다. 그럼에도 불구하고 몸의 곳곳이 산소와 영양분을 필요로 하므로 적혈구는 가만히 있을 수 없으며, 매 초 통로를 무조건 하나 타야 한다. 일부 통로는 출발 거점과 도착 거점이 같을 수도 있다. 일부 거점의 특정 순간에는 나가는 통로가 없을 수도 있는데, 이 때는 도착한지 1초 후에 파괴되어 몸과 다시 하나가 된다. 잔혹하지만 우리의 몸은 이렇게 돌아간다.

우리의 적혈구는 매 순간 변하는 몸속 혈관 지도에 길을 헤매지만 그래도 최선을 다해서 하루하루 열심히 일을 하고 있다. 옆에 있던 백혈구가 길을 헤매는 적혈구를 보고 도와주고 싶다는 생각을 했다.

수십 시간의 유주 경험을 통해 백혈구는 몸속 혈관 지도가 T 초를 주기로 반복된다는 것을 알게 되었다. 이 사실을 정리해서 적혈구가 거점 A에서 출발하여 정확히 D초 후 거점 B에 도달하게 되는 경우의 수를 모든 거점의 순서쌍에 대해 구해주고자 하지만 너무나도 단세포이기 때문에 머리가 나빠서 계산을 하지 못했다. 한 경로는, D초 동안 통과한 통로의 순열로 정의된다. 백혈구를 도와서 적혈구가 D초 동안 한 거점에서 다른 거점까지 움직일 수 있는 경우의 수를 구해주자!

입력
첫 번째 줄에는 백혈구가 알아낸 혈관 지도들의 주기인 자연수 T 와 거점의 개수인 자연수 N, 적혈구가 움직이는 시간인 정수 D 가 공백으로 구분되어 주어진다. (1 ≤ T ≤ 100, 2 ≤ N ≤ 20, 0 ≤ D ≤ 109)

그 뒤 거점 사이의 연결 관계를 나타내는 혈관 지도 T 개가 순서대로 1번부터 T 번까지 주어지는데, 혈관 지도가 주어지는 형식은 다음과 같다.

첫 번째 줄에는 거점 사이를 잇는 혈관의 개수인 자연수 Mi 가 주어진다. (0 ≤ Mi ≤ N2)
그 뒤 Mi 개의 줄에 걸쳐 세 자연수 a, b, c가 공백으로 구분되어 주어진다. 이는 거점 a 에서 거점 b 로 가는 서로 다른 단방향 통로가 c 개 있음을 의미한다. (1 ≤ a, b ≤ N, 1 ≤ c ≤ 1000)
매 혈관 지도에 중복된 연결 관계는 주어지지 않는다.
i 초에서 (i+1)초 동안 이동할 때는 (i % T + 1)번 혈관 지도가 적용된다. i % T는 i를 T로 나눈 나머지를 의미한다.

출력
출력은 N개의 줄로 구성되며, i 번째 줄에는 N개의 정수 xi1, xi2, ..., xiN를 공백으로 구분하여 출력해야 한다. xij는 0초 때 거점 i 에서 출발하여 정확히 D초 때 거점 j에 위치하게 되는 경로의 수를 1,000,000,007로 나눈 나머지이다.
*/

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");
    public static void main(String[] args) throws IOException {
    	int T = in(), N = in(), D = in(), P = D/T;
		int[][] res = new int[N][N], remain = new int[N][N], bin[] = new int[31][N][N];
    	for(int i = 0; i < N; i++) remain[i][i] = res[i][i] = bin[0][i][i] = 1;
    	for(int t = 0; t < T; t++) {
    		int[][] mx = new int[N][N];
    		for(int i = 0, M = in(); i < M; i++) mx[in()-1][in()-1] = in();
    		if (t < D%T) remain = mult(remain, mx, N);
    		bin[0] = mult(bin[0], mx, N);
    	}
    	for(int i = 1; i < 31; i++) bin[i] = mult(bin[i-1], bin[i-1], N);
    	for(int i = 30; i >= 0 && P != 0; i--) if (P >= 1<<i) {P -= 1<<i; res = mult(res, bin[i], N);}
    	res = mult(res, remain, N);
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < N; sb.append("\n"), i++) for(int j = 0; j < N; j++) sb.append(res[i][j]).append(" ");
    	System.out.print(sb);
    }
    static int in() throws IOException {
    	if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
    	return Integer.parseInt(st.nextToken());
    }
    static int[][] mult(int[][] m1, int[][] m2, int N) {
        int res[][] = new int[N][N], INF = 1000000007;
        for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) for(int k = 0; k < N; k++)
        	res[i][j] = (res[i][j] += (long)m1[i][k] * m2[k][j] % INF) % INF;
        return res;
    }
}
