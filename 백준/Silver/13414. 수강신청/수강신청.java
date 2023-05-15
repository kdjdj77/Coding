import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		Set<String> set = new LinkedHashSet<>();
		while(N-- > 0) {
			String num = br.readLine();
			if (set.contains(num)) set.remove(num);
			set.add(num);
		}
		for(String n : set) {
			sb.append(n).append("\n");
			if (--K == 0) break;
		}
		System.out.print(sb);
    }
}