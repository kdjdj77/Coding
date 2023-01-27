import java.io.*;
import java.util.*;
 
public class Main {
	static List<Integer> res = new ArrayList<>();;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		String find = br.readLine();
		
		kmp(str, find, pi(find));
		
		sb.append(res.size()).append("\n");
		for(int idx : res) sb.append(idx).append(" ");
		System.out.println(sb);
	}
	static void kmp(String str, String find, int[] pi) {
		int idx = 0;
		int strLen = str.length();
		int findLen = find.length();
		
		for(int i = 0; i < strLen; i++) {
			while(idx > 0 && str.charAt(i) != find.charAt(idx)) idx = pi[idx - 1];
			
			if(str.charAt(i) == find.charAt(idx)) {
				if(idx + 1 == findLen) {
					res.add(i-findLen+2);
					idx = pi[idx];
				}
				else idx++;
			}
		}
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