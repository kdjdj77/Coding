import java.io.*;
import java.util.*;

public class Main {
	static class Trie {
	    boolean isEnd = false;
	    Trie[] next = new Trie[26];
	    Trie add(int n) {return next[n] = next[n] == null ? new Trie() : next[n];}
	}
    static Set<String> name = new HashSet<>();
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Trie root = new Trie();
        int C = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        while(C-- > 0) {
            Trie cur = root;
            String str = br.readLine();
            for(int i = 0, len = str.length(); i < len; i++) cur = cur.add(str.charAt(i)-97);
            cur.isEnd = true;
        }
        while(N-- > 0) name.add(br.readLine());
        int Q = Integer.parseInt(br.readLine());
        while(Q-- > 0) sb.append(res(br.readLine(), root) ? "Yes\n" : "No\n");
        System.out.print(sb);
    }
    static boolean res(String str, Trie root) {
        Trie cur = root;
        for(int i = 0, len = str.length(); i < len; i++) {
            cur = cur.next[str.charAt(i)-'a'];
            if (cur == null) return false;
            if (cur.isEnd && name.contains(str.substring(i+1))) return true;
        }
        return false;
    }
}