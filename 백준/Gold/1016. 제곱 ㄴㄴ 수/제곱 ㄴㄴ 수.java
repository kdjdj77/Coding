import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken()), max = Long.parseLong(st.nextToken());
		int res = (int)(max-min) + 1;
		boolean[] check = new boolean[res];
		for(long i = 2; i*i <= max; i++) {
			long pow = i*i, k = min/pow;
			if (min%pow != 0) k += 1;
			for(long j = k; j*pow <= max; j++) {
				int pos = (int)(j*pow-min);
				if (!check[pos]) {check[pos] = true; res--;}
			}
		}
		System.out.print(res);
    }
}