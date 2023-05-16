import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), U[] = new int[N];
		for(int i = 0; i < N; i++) U[i] = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> sum = new ArrayList<>();
		for(int x = 0; x < N; x++) for(int y = 0; y < N; y++) sum.add(U[x] + U[y]);
		Arrays.sort(U);
		Collections.sort(sum);
		
		int res = 0;
		for(int k = N-1; k >= 0; k--) for(int z = 0; z < k; z++)
			if (bs(U[k]-U[z], sum)) res = Math.max(res, U[k]);
		System.out.print(res);
	}
	private static boolean bs(int num, ArrayList<Integer> sum) {
		int s = 0, e = sum.size()-1;
		while(s < e) {
			int m = (s + e) / 2;
			if (sum.get(m) > num) e = m-1;
			else if (sum.get(m) < num) s = m+1;
			else return true;
		}
		return false;
	}
}