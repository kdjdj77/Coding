package q00_ETC.rank5p.a1208;
/*
문제
N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 40, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 주어지는 정수의 절댓값은 100,000을 넘지 않는다.

출력
첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	static long res = 0;
    static int N, S, seq[], cnt[], MID = 3000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); S = Integer.parseInt(st.nextToken());
        seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        cnt = new int[MID*2+1];
        subSeq(0, N/2, 0);
        subSeq(N/2, N, 0);
        System.out.print(S == 0 ? res-1 : res);
    }
    static void subSeq(int i, int e, int sum) {
        if (i == e) {
            if (e == N) res += cnt[S+MID-sum];
            else cnt[sum+MID]++;
            return;
        }
        subSeq(i+1, e, sum+seq[i]);
        subSeq(i+1, e, sum);
    }
}