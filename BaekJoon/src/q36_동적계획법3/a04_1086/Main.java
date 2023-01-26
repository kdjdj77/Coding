package q36_동적계획법3.a04_1086;
/*
문제
박성원은 이 문제를 풀지 못했다.

서로 다른 정수로 이루어진 집합이 있다. 이 집합의 순열을 합치면 큰 정수 하나를 만들 수 있다. 예를 들어, {5221,40,1,58,9}로 5221401589를 만들 수 있다. 합친수가 정수 K로 나누어 떨어지는 순열을 구하는 프로그램을 작성하시오.

하지만, 박성원은 이 문제를 풀지 못했다.

따라서 박성원은 그냥 랜덤하게 순열 하나를 정답이라고 출력하려고 한다. 이 문제에는 정답이 여러 개 있을 수도 있고, 박성원이 우연히 문제의 정답을 맞출 수도 있다.

박성원이 우연히 정답을 맞출 확률을 분수로 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 집합의 수의 개수 N이 주어진다. N은 15보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 집합에 포함된 수가 주어진다. 각 수의 길이는 길어야 50인 자연수이다. 마지막 줄에는 K가 주어진다. K는 100보다 작거나 같은 자연수이다.

출력
첫째 줄에 정답을 기약분수 형태로 출력한다. p/q꼴로 출력하며, p는 분자, q는 분모이다. 정답이 0인 경우는 0/1로, 1인 경우는 1/1로 출력한다.
*/

import java.io.*;
 
public class Main {
	static long[][] dp;
	static int N, K, bit, mods[][];
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        String[] nums = new String[N];
        mods = new int[N][2];
        bit = (1 << N);
        for(int i = 0; i < N; i++) nums[i] = br.readLine();

        K = Integer.parseInt(br.readLine());
        dp = new long[bit][K];
        
        for(int i = 0; i < N; i++) {
            mods[i][1] = 1;
            int len = nums[i].length();
            for(int j = 0; j < len; j++) mods[i][1] = (mods[i][1] * 10) % K;
            mods[i][0] = mod(nums[i], K);
            dp[1<<i][mods[i][0]] = 1;
        }
        set(0);

        long res = dp[(1<<N)-1][0];
        long pac = 1;
        for(int i = 2; i <= N; i++) pac *= i;
        
        if(res == 0) sb.append("0/1");
        else {
            long gcd = gcd(pac,res);
            sb.append(res/gcd).append("/").append(pac/gcd);
        }
        System.out.print(sb);
    }
    static void set(int visit) {
    	if (visit == bit) return;
    	for(int idx = 0; idx < N; idx++) {
        	int cur = 1 << idx;
            if ((visit & cur) > 0) continue;
            
            for(int m = 0; m < K; m++) {
            	int mod = ((m * mods[idx][1]) % K + mods[idx][0]) % K;
                dp[visit|cur][mod] += dp[visit][m];
            }
        }
    	set(visit+1);
    }
    static int mod(String n, int k) {
        int res = 0;
        for(int i = 0; i < n.length(); i++)
        	res = (res*10 + n.charAt(i) - 48) % k;
        return res;
    }
    static long gcd(long a, long b) {
        long c = a % b;
        if(c == 0) return b;
        return gcd(b,c);
    }
}