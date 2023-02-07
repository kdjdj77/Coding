import java.io.*;
import java.util.*;

class Node {
	Map<Character, Node> next = new HashMap<>();
	boolean isEnd;
	
	public void insert(String s) {
		Node cur = this;
	    for(int i = 0; i < s.length(); i++) {
	    	char c = s.charAt(i);
	    	cur.next.put(c, cur.next.getOrDefault(c, new Node()));
	    	cur = cur.next.get(c);
	    }
	    cur.isEnd = true;
	}
	public int press(String word) {
		 int res = 1;
		 Node cur = this.next.get(word.charAt(0));
		 
		 for(int i = 1; i < word.length(); i++) {
			 if(cur.next.size() > 1) res++;
			 else if (cur.next.size() == 1 && cur.isEnd) res++;
			 cur = cur.next.get(word.charAt(i));
	    }
	    return res;
	 }
}
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		while(true) {
			if ("".equals(str) || str == null) break;
			
			int N = Integer.valueOf(str);
			String[] list = new String[N];
			Node root = new Node();
			
			for(int i = 0; i < N; i++) root.insert(list[i] = br.readLine());
			
			double sum = 0;
			for(String s : list) sum += root.press(s);
			sb.append(String.format("%.2f\n", sum / N));
			
			str = br.readLine();
		}
		System.out.print(sb);
	}
}