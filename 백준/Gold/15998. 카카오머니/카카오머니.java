import java.io.*;
import java.util.*;

public class Main {
	static long MAX = Long.MAX_VALUE;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long min = MAX, remain = 0, M = 0;
        boolean error = false;
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken());
            if (remain + a < 0) {
                long calc = b - a - remain;
                if (b != 0 && b < min) min = b;
                
                if (M == 0) M = calc;
                else if ((M = gcd(M, calc)) <= min && min != MAX) {error = true; break;}
            } else if (b != remain + a) {error = true; break;}
            remain = b;
        }
        System.out.print(error ? -1 : M != 0 ? M : 1);
    }
    static long gcd(long a, long b) {
        while(b > 0) {long tmp = a; a = b; b = tmp % b;}
        return a;
    }
}