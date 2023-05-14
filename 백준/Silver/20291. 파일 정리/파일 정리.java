import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new TreeMap<>();
		while(N-- > 0) {
			String[] s = br.readLine().split("\\.");
			map.put(s[1], map.getOrDefault(s[1], 0) + 1);
		}
		for(String s : map.keySet()) sb.append(s).append(" ").append(map.get(s)).append("\n");
		System.out.print(sb);
    }
}