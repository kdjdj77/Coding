import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, TreeSet<String>> quiz1 = new HashMap<>();
		Map<String, String> quiz2 = new HashMap<>();
		while(N-- > 0) {
			String team = br.readLine();
			TreeSet<String> member = new TreeSet<>();
			int cnt = Integer.parseInt(br.readLine());
			while(cnt-- > 0) {
				String name = br.readLine();
				member.add(name);
				quiz2.put(name, team);
			}
			quiz1.put(team, member);
		}
		while(M-- > 0) {
			String test = br.readLine();
			if (Integer.parseInt(br.readLine()) == 1) sb.append(quiz2.get(test)).append("\n");
			else quiz1.get(test).stream().forEach(s -> sb.append(s).append("\n"));
		}
		System.out.print(sb);
    }
}