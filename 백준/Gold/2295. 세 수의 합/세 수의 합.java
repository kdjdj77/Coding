import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), U[] = new int[N];
		for(int i = 0; i < N; i++) U[i] = Integer.parseInt(br.readLine());
		br.close();
		
		Arrays.sort(U);
		Set<Integer> xySum = new HashSet<>();
		for(int x : U) for(int y : U) xySum.add(x+y);
		
		for (int k = N-1; k >= 0; k--) for (int z = N-1; z >= 0; z--)
			if (xySum.contains(U[k]-U[z])) { System.out.print(U[k]); return; }
	}
}