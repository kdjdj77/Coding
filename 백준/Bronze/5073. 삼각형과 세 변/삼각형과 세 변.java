import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] A = new int[3];
			for(int i = 0; i < 3; i++) A[i] = Integer.parseInt(st.nextToken());
			if (A[0] == 0) break;
			
			Arrays.sort(A);
			if (A[0] + A[1] <= A[2]) sb.append("Invalid\n");
			else if (A[0] == A[1] && A[1] == A[2]) sb.append("Equilateral\n");
			else sb.append(A[0] == A[1] || A[1] == A[2] ? "Isosceles\n" : "Scalene\n");
		}
		System.out.print(sb);
	}
}