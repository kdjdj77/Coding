import java.io.*;
import java.util.*;

public class Main {
	private static Map<Long, Long> dp;
	private static long P, Q;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		
		dp = new HashMap<>();
		dp.put(0L, 1L);
		System.out.print(A(N));
    }
    private static long A(long i) {
    	if (dp.containsKey(i)) return dp.get(i);
    	long res = A(i/P) + A(i/Q);
    	dp.put(i, res);
    	return res;
    }
}