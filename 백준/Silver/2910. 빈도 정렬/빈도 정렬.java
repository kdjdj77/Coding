import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int o = 0;
		
		Map<Integer, Integer> order = new HashMap<>();
		Map<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (map.containsKey(num)) map.put(num, map.get(num) + 1);
			else {
				map.put(num, 1);
				order.put(num, o++);
			}
		}
		ArrayList<Integer> arr = new ArrayList<>();
		for(int a : map.keySet()) arr.add(a);
		Collections.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (map.get(o1) == map.get(o2)) return order.get(o1) - order.get(o2);
				else return map.get(o2) - map.get(o1);
			}
		});
		for(int a : arr) for(int i = 0; i < map.get(a); i++) sb.append(a).append(" ");
		System.out.print(sb);
    }
}