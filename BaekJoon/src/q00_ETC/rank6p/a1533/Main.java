package q00_ETC.rank6p.a1533;
/*
문제
세준이는 정문이를 데리러 공항으로 가기로 했다. 하지만, 방금 세준이는 정문이의 비행기가 연착된다는 전화를 받았다. 세준이는 정문이가 정확하게 몇 분 늦는지 알고 있고, 그 시간 동안 밖에서 드라이브를 하려고 한다. 정문이가 늦는 시간을 T라고 하자.

세준이는 자기가 지금 있는 위치에서부터, 공항까지 정확하게 T분만에 도착하는 경로의 개수를 구하고 싶다.

길의 정보는 인접행렬로 주어진다. A[i][j]가 0이라면 i에서 j로 가는 길이 없는 것이고, A[i][j] ≤ 5라면, 정확히 그 만큼의 시간이 걸리는 i에서 j로 가는 길이 있는 것이다.

입력
첫째 줄에 교차점의 개수 N이 주어진다. N은 10보다 작거나 같고, 시작점의 위치 S와 끝점의 위치 E, 그리고 정문이가 늦는 시간 T도 주어진다. S와 E는 N보다 작거나 같은 자연수이다. T는 1,000,000,000보다 작거나 같은 자연수이다. 둘째 줄부터 길의 정보가 주어진다.

출력
첫째 줄에 경로의 개수를 1,000,003로 나눈 나머지를 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
    	st = new StringTokenizer(br.readLine());
        int N = in(), S = in(), E = in(), T = in(), L = N*5;
        long[][] path = new long[L+1][L+1], res = new long[L+1][L+1];
        for(int i = 1; i <= L; i++) res[i][i] = 1;
        for(int i = 1; i <= N; i++, br.readLine()) {
            for(int j = 0, w; j < N; j++) if ((w = br.read()-'0') > 0) path[i*5][(j+1)*5-w+1] = 1;
            for(int j = 1; j < 5; j++) path[(i-1)*5+j][(i-1)*5+j+1] = 1;
        }
        for(int i = T; i > 0; i /= 2, path = mult(path, path, L)) if (i % 2 == 1) res = mult(res, path, L);
        System.out.print(res[S*5][E*5]);
    }
    static int in() {return Integer.parseInt(st.nextToken());}
    static long[][] mult(long[][] a, long[][] b, int L) {
        long[][] res = new long[L+1][L+1];
        for(int i = 1; i <= L; i++) for(int j = 1; j <= L; j++) for(int k = 1; k <= L; k++)
        	res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % 1000003;
        return res;
    }
}