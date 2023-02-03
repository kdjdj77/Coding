package q37_문자열알고리즘1.a05_5670;
/*

*/

import java.io.*;
import java.util.*;
 
class Node{
    Map<Character, Node> next = new HashMap<>();
    boolean isEnd;
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        Node root = new Node();
        
        String str = br.readLine();
        while(!str.equals("") && str != null) {
            int N = Integer.parseInt(str);
            String[] list = new String[N];
            
            for(int i = 0; i < N; i++) {
            	Node cur = root;
                String s = list[i] = br.readLine();
                for(int j = 0; j < s.length(); j++) {
                	char c = s.charAt(j);
	                cur.next.put(c, cur.next.getOrDefault(c, new Node()));
	                if (j == s.length()-1) cur.isEnd = true;
	                cur = cur.next.get(c);
                }
            }
            
            double res = 0;
            for(int i = 0; i < N; i++) {
            	Node cur = root;
            	String s = list[i];
            	for(int j = 0; j < s.length(); j++) {
            		char c = s.charAt(j);
            		if (cur.next.size() > 1 && j != s.length()-1) res++;
            		else if (cur.isEnd) res++;
            		cur = cur.next.get(c);
            	}
            }
            System.out.print(String.format("%.2f\n", res/N));
            sb.append(String.format("%.2f\n", res/N));
            str = br.readLine();
        }
        System.out.print(sb);
    }
}