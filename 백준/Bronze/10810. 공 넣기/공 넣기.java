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
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int[] b = new int[3];
			for(int i = 0; i < 3; i++) b[i] = Integer.parseInt(st.nextToken());
			for(int i = b[0]; i <= b[1]; i++) a[i] = b[2];
		}
		for(int i = 1; i <= N; i++) sb.append(a[i]).append(" ");
		System.out.print(sb);
	}
}