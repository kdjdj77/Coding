import java.io.*;
import java.util.*;

class Node{
    Map<String, Node> next = new HashMap<>();
}
public class Main {
	static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        Node root = new Node();

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            
            Node cur = root;
            while(K-- > 0) {
                String s = st.nextToken();
                cur.next.put(s, cur.next.getOrDefault(s, new Node()));
                cur = cur.next.get(s);
            }
        }
        setSB("", root);
        System.out.print(sb);
    }
    public static void setSB(String tag, Node n){
        String[] nexts = n.next.keySet().toArray(new String[0]);
        Arrays.sort(nexts);

        for (String s : nexts){
            sb.append(tag).append(s).append("\n");
            setSB(tag + "--", n.next.get(s));
        }
    }
}