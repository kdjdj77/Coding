import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long ans = 0;
		int T = Integer.parseInt(br.readLine()), N = Integer.parseInt(br.readLine());
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int M = Integer.parseInt(br.readLine());
		int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) for(int j=i, sum=0; j<N; j++) map.put(sum += A[j], map.getOrDefault(sum, 0)+1);
		for(int i=0; i<M; i++) for(int j=i, sum=0; j<M; j++) ans += map.getOrDefault(T - (sum += B[j]), 0);
		System.out.print(ans);
	}
}