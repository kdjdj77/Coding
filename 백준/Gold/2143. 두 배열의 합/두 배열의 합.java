import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Integer> subA = new ArrayList<>(), subB = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		int T = in();
		int N = in(), A[] = new int[N+1]; StringTokenizer st1 = new StringTokenizer(br.readLine());
		int M = in(), B[] = new int[M+1]; StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) A[i] = A[i-1] + Integer.parseInt(st1.nextToken());
		for(int i = 1; i <= M; i++) B[i] = B[i-1] + Integer.parseInt(st2.nextToken());
		for(int s = 1; s <= N; s++) for(int e = s; e <= N; e++) subA.add(A[e] - A[s-1]);
		for(int s = 1; s <= M; s++) for(int e = s; e <= M; e++) subB.add(B[e] - B[s-1]);
		Collections.sort(subA);
		Collections.sort(subB);
		System.out.print(res(T));
	}
	static int in() throws IOException {return Integer.parseInt(br.readLine());}
	static long res(int T) {
		long res = 0;
		int sA = 0, eA = subA.size(), eB = subB.size()-1;
		while(sA < eA && eB >= 0) {
			int sum = subA.get(sA) + subB.get(eB);
			if (sum == T) {
				int a = subA.get(sA), b = subB.get(eB);
				long cntA = 0, cntB = 0;
				while(sA < eA && subA.get(sA) == a) {sA++; cntA++;}
				while(eB >= 0 && subB.get(eB) == b) {eB--; cntB++;}
				res += cntA * cntB;
			} else if (sum < T) sA++; else eB--;
		}
		return res;
	}
}