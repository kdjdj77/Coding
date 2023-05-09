import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] a = new int[N+1];
		for(int i = 1; i <= N; i++) a[i] = i;
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			a[0] = a[s]; a[s] = a[e]; a[e] = a[0];
		}
		for(int i = 1; i <= N; i++) sb.append(a[i]).append(" ");
		System.out.print(sb);
	}
}