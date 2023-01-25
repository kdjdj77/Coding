import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int dp = 0;
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			if (s.equals("all")) { dp = (1 << 21) - 1; continue;}
			if (s.equals("empty")) { dp = 0; continue;}
			
			int b = Integer.parseInt(st.nextToken());
			if (s.equals("add")) dp |= 1 << b;
			else if (s.equals("remove")) dp &= ~(1 << b);
			else if (s.equals("check")) sb.append((dp & (1 << b)) == (1 << b) ? "1\n" : "0\n");
			else if (s.equals("toggle")) dp ^= (1 << b);
		}
		System.out.print(sb);
	}
}