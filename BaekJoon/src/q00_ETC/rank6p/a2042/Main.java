package q00_ETC.rank6p.a2042;
/*
문제
어떤 N개의 수가 주어져 있다. 그런데 중간에 수의 변경이 빈번히 일어나고 그 중간에 어떤 부분의 합을 구하려 한다. 만약에 1,2,3,4,5 라는 수가 있고, 3번째 수를 6으로 바꾸고 2번째부터 5번째까지 합을 구하라고 한다면 17을 출력하면 되는 것이다. 그리고 그 상태에서 다섯 번째 수를 2로 바꾸고 3번째부터 5번째까지 합을 구하라고 한다면 12가 될 것이다.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)과 M(1 ≤ M ≤ 10,000), K(1 ≤ K ≤ 10,000) 가 주어진다. M은 수의 변경이 일어나는 횟수이고, K는 구간의 합을 구하는 횟수이다. 그리고 둘째 줄부터 N+1번째 줄까지 N개의 수가 주어진다. 그리고 N+2번째 줄부터 N+M+K+1번째 줄까지 세 개의 정수 a, b, c가 주어지는데, a가 1인 경우 b(1 ≤ b ≤ N)번째 수를 c로 바꾸고 a가 2인 경우에는 b(1 ≤ b ≤ N)번째 수부터 c(b ≤ c ≤ N)번째 수까지의 합을 구하여 출력하면 된다.

입력으로 주어지는 모든 수는 -2^63보다 크거나 같고, 2^63-1보다 작거나 같은 정수이다.

출력
첫째 줄부터 K줄에 걸쳐 구한 구간의 합을 출력한다. 단, 정답은 -2^63보다 크거나 같고, 2^63-1보다 작거나 같은 정수이다.
*/

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static long[] num, tree;
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder(); st();
        N = in(); M = in() + in(); num = new long[N+1]; tree = new long[N+1];
        for(int i = 1; i <= N; i++) set(i, num[i] = Long.parseLong(br.readLine()));
        while(M-- > 0) {st();
        	int a = in(), b = in();
            if (a == 2) {sb.append(res(in()) - res(b-1)).append("\n"); continue;}
            long c = Long.parseLong(st.nextToken()), dif = c - num[b]; num[b] = c;
            set(b, dif);
        }
        System.out.print(sb);
    }
    static int in() {return Integer.parseInt(st.nextToken());}
    static void st() throws IOException {st = new StringTokenizer(br.readLine());}
    static void set(int n, long dif) {for(;n <= N; n += n & -n) tree[n] += dif;}
    static long res(int n) {long rt = 0; for(;n > 0; n -= n & -n) rt += tree[n]; return rt;}
}