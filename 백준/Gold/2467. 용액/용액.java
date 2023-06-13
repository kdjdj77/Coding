import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sol = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int l = 0, r = N-1, sum = Integer.MAX_VALUE, res[] = {0, 0};
        while(l < r) {
        	int ls = sol[l], rs = sol[r], mix = ls + rs;
        	if (Math.abs(mix) < Math.abs(sum)) {
        		res = new int[] {ls, rs};
        		if (0 == (sum = mix)) break;
        	}
        	N = mix < 0 ? l++ : r--;
        }
        System.out.print(new StringBuilder().append(res[0]).append(" ").append(res[1]));
    }
}