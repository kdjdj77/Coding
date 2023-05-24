import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] s = new String[5];
		for(int i = 0; i < 5; i++) s[i] = br.readLine();
		
		int idx = 0;
		boolean stop = false;
		while(!stop) {
			stop = true;
			for(int i = 0; i < 5; i++) {
				if (idx >= s[i].length()) continue;
				sb.append(s[i].charAt(idx));
				stop = false;
			}
			idx++;
		}
		System.out.print(sb);
	}
}