import java.io.*;
import java.util.*;

public class Main {
	static class Trie {
	    boolean isEnd = false;
	    Trie[] next = new Trie[26];
	    Trie add(char c) {return next[c-'a'] = next[c-'a'] == null ? new Trie() : next[c-'a'];}
	}
    static Set<String> name = new HashSet<>();
    static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Trie root = new Trie();
        st = new StringTokenizer(read());
        int C = in(), N = in();
        while(C-- > 0) {
            Trie cur = root;
            String str = read();
            for(int i = 0, len = str.length(); i < len; i++) cur = cur.add(str.charAt(i));
            cur.isEnd = true;
        }
        while(N-- > 0) name.add(read());
        int Q = Integer.parseInt(read());
        while(Q-- > 0) sb.append(res(read(), root) ? "Yes\n" : "No\n");
        System.out.print(sb);
    }
    static String read() throws IOException {return br.readLine();}
    static int in() {return Integer.parseInt(st.nextToken());}
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