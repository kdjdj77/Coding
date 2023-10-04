import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		boolean[] S = new boolean[400001];
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				int cur = A[i] + A[j];
				if (cur >= W || W > 400000 + cur) continue;
				if (S[W-cur]) {System.out.print("YES"); return;}
			}
			for(int j = 0; j < i; j++) S[A[i]+A[j]] = true;
		}
		System.out.print("NO");
	}
}