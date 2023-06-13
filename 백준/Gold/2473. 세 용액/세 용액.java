import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long a = 0, b = 0, c = 0, d = 1L<<32;
        long[] sol = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(sol);
        for(int l = 0; l < N-2; l++) {
        	int m = l+1, r = N-1;
            while(m < r) {
                long sum = sol[l] + sol[m] + sol[r];
                if (Math.abs(sum) < Math.abs(d)) {
                    a = sol[l]; b = sol[m]; c = sol[r];
                    if ((d = sum) == 0) break;
                }
                if (sum < 0) m++; else r--;
            }
        }
        System.out.print(new StringBuilder().append(a).append(" ").append(b).append(" ").append(c));
    }
}