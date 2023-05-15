import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()), len = 0;
		char res = 0;
		Set<String> set = new HashSet<>();
		while(N-- > 0) set.add(br.readLine());
		
		for(String s : set) {
			len = s.length();
			StringBuilder sb2 = new StringBuilder();
			for(int i = len-1; i >= 0; i--) sb2.append(s.charAt(i));
			String tmp = sb2.toString();
			if (set.contains(tmp)) { res = s.charAt(len/2); break; }
		}
		sb.append(len).append(" ").append(res);
		System.out.print(sb);
    }
}