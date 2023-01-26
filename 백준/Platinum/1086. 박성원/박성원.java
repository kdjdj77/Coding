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