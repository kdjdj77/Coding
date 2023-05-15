import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		
		while(N-- > 0) {
			String s = br.readLine();
			if (s.length() >= M) {
				map.put(s, map.getOrDefault(s, 0) + 1);
				set.add(s);
			}
		}
		ArrayList<String> words = new ArrayList<>(set);
		words.stream().sorted(new Comparator<>() {
			@Override
			public int compare(String o1, String o2) {
				if (map.get(o1) != map.get(o2)) return map.get(o2) - map.get(o1);
				if (o1.length() != o2.length()) return o2.length() - o1.length();
				return o1.compareTo(o2);
			}
		}).forEach(w -> sb.append(w).append("\n"));;
		System.out.print(sb);
    }
}