import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[3];
		for(int i = 0; i < 3; i++) A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		int sum2 = A[0]+A[1];
		System.out.print(sum2 <= A[2] ? sum2*2-1 : sum2+A[2]);
	}
}