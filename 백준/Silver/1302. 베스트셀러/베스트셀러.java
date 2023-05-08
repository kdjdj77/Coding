import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String res = null;
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		while(N-- > 0) {
			String s = br.readLine();
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		for(String s : map.keySet()) {
			int tmp = map.get(s);
			if (tmp > N) N = map.get(res = s);
			else if (tmp == N) res = res.compareTo(s) > 0 ? s : res;
		}
		System.out.print(res);
    }
}