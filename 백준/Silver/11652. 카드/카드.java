import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Map<Long, Integer> map = new HashMap<>();
		while(N-- > 0) {
			Long a = Long.parseLong(br.readLine());
			map.put(a, map.getOrDefault(a, 0) + 1);
		}
		Long res = Long.MAX_VALUE;
		for(Long s : map.keySet()) {
			int tmp = map.get(s);
			if (tmp > N) N = map.get(res = s);
			else if (tmp == N) res = res < s ? res : s;
		}
		System.out.print(res);
    }
}