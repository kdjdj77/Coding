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