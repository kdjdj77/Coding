import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			String name = br.readLine();
			map.put(name, map.getOrDefault(name, 0) + 1);
		}
		while(N-- > 1) {
			String name = br.readLine();
			map.put(name, map.get(name) - 1);
			if (map.get(name) == 0) map.remove(name);
		}
		map.keySet().stream().forEach(n -> System.out.print(n));
    }
}