import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		TreeSet<String> set = new TreeSet<>();
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			if ("enter".equals(st.nextToken())) set.add(name);
			else set.remove(name);
		}
		Iterator<String> iter = set.descendingIterator();
		while(iter.hasNext()) sb.append(iter.next()).append("\n");
		System.out.print(sb);
    }
}