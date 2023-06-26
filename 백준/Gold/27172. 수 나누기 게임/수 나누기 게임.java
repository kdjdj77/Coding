import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()), X[] = new int[N], INF = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) INF = Math.max(INF, X[i] = Integer.parseInt(st.nextToken()));
		
		int[] P = new int[N+1], pos = new int[INF+1];
		for(int i = 0; i < N; i++) pos[X[i]] = i+1;

		for(int m : X) for(int j = m*2; j <= INF; j += m) if (pos[j] != 0) {P[pos[j]]--; P[pos[m]]++;}
		for(int i = 1; i <= N; i++) sb.append(P[i]).append(" ");
		System.out.print(sb);
	}
}