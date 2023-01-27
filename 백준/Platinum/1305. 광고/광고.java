import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int[] pi = pi(str);
		System.out.print(L - pi[L-1]);
	}
	static int[] pi(String s) {
		int idx = 0, n = s.length();
		int[] pi = new int[n];
		
		for(int i = 1; i < n; i++) {
			while(idx > 0 && s.charAt(idx) != s.charAt(i)) idx = pi[idx - 1];
			if(s.charAt(idx) == s.charAt(i)) pi[i] = ++idx;
		}
		return pi;
	}
}