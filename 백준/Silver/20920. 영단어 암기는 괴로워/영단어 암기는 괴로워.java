import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new LinkedHashMap<>();
		
		while(N-- > 0) {
			String s = br.readLine();
			if (s.length() >= M) map.put(s, map.getOrDefault(s, 0) + 1);
		}
		map.keySet().stream().sorted(new Comparator<>() {
			@Override
			public int compare(String o1, String o2) {
				int m1 = map.get(o1), m2 = map.get(o2), l1 = o1.length(), l2 = o2.length();
				return m1 != m2 ? m2 - m1 : (l1 != l2 ? l2 - l1 : o1.compareTo(o2));
			}
		}).forEach(w -> sb.append(w).append("\n"));
		System.out.print(sb);
    }
}