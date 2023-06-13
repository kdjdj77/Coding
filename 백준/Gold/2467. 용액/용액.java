import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), l = 0, r = N-1, a = 0, b = 0, c = (1<<31)-1;
        int[] sol = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        while(l < r) {
        	int sum = sol[l] + sol[r];
        	if (Math.abs(sum) < Math.abs(c)) {
        		a = sol[l]; b = sol[r];
        		if ((c = sum) == 0) break;
        	}
        	N = sum < 0 ? l++ : r--;
        }
        System.out.print(new StringBuilder().append(a).append(" ").append(b));
    }
}