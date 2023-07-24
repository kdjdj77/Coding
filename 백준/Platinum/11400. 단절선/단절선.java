import java.io.*;
import java.util.*;

public class Main {
	static int V, E, N[], cnt = 0;
	static ArrayList<Integer>[] link;
	static ArrayList<int[]> res = new ArrayList<>();
    public static void main(String[] args) throws IOException {
    	Reader fr = new Reader();
        link = new ArrayList[(V = fr.ni()+1)]; N = new int[V+1]; E = fr.ni();
        for(int i = 1; i < V; i++) link[i] = new ArrayList<>();
        for(int i = 0, a, b; i < E; i++) {link[a=fr.ni()].add(b=fr.ni()); link[b].add(a);}
        for(int i = 1; i < V; i++) if (N[i] == 0) dfs(1, 0);
        Collections.sort(res, (a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        StringBuilder sb = new StringBuilder().append(res.size()).append("\n");
        for(int[] r : res) sb.append(r[0]).append(" ").append(r[1]).append("\n");
        System.out.print(sb);
    }
    static int[] arr(int a, int b) {return a < b ? new int[] {a, b} : new int[] {b, a};}
    static int dfs(int cur, int before) {
    	int min = N[cur] = ++cnt, min2;
    	for(int next : link[cur]) {
    		if (next == before) continue;
    		if (N[next] != 0) min2 = N[next];
    		else if ((min2 = dfs(next, cur)) > N[cur]) res.add(arr(cur, next));
            min = Math.min(min, min2);
        }
    	return min;
    }
}
class Reader {
	BufferedReader br; StringTokenizer st;
    public Reader(){br=new BufferedReader(new InputStreamReader(System.in));}
    String ns(){if(st==null||!st.hasMoreTokens())try{st=new StringTokenizer(br.readLine());}catch(Exception e){}return st.nextToken();}
    int ni(){return Integer.parseInt(ns());}
}