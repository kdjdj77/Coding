import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());		
		Map<Integer, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		
		int res = 0;
		Set<Integer> set = map.keySet();
		for(int n : set) for(int k : set) {
			if (n == 0 && k == 0 && map.get(0) < 3) continue; 
			if (n-k == 0 || k == 0) if (map.get(n) == 1) continue;
			if (n-k == k && map.get(k) == 1) continue;
			if (set.contains(n-k)) {
				res += map.get(n);
				break;
			}
		}
		System.out.print(N < 3 ? 0 : res);
    }
}