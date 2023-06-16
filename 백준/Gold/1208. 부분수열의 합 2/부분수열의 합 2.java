import java.io.*;
import java.util.*;

public class Main {
	static long[] seq;
	static ArrayList<Long> L = new ArrayList<>(), R = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());
		seq = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		subSeq(0, N/2, 0, L); Collections.sort(L);
		subSeq(N/2, N, 0, R); Collections.sort(R, Collections.reverseOrder());
		System.out.println(res(S, 0) - (S == 0 ? 1 : 0));
	}
	static void subSeq(int i, int e, long sum, ArrayList<Long> ss) {
		if (i == e) {ss.add(sum); return;}
		subSeq(i+1, e, sum+seq[i], ss);
		subSeq(i+1, e, sum, ss);
	}
	static long res(int S, long res) {
		int l = 0, r = 0;
		while (r < R.size() && l < L.size()) {
			long sum = L.get(l) + R.get(r);
			if (sum == S) {
				long sl = L.get(l), sr = R.get(r), cntL = 0, cntR = 0;
				while (l < L.size() && L.get(l) == sl) {l++; cntL++;}
				while (r < R.size() && R.get(r) == sr) {r++; cntR++;}
				res += cntL * cntR;
			} else if (sum < S) l++; else r++;
		}
		return res;
	}
}