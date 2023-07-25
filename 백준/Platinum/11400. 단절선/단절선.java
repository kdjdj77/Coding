import java.io.*;
import java.util.*;

public class Main {
	static class Line implements Comparable<Line> {
		int a, b; 
		Line(int x, int y) {a = x; b = y;}
		@Override
		public int compareTo(Line o) {return a == o.a ? b - o.b : a - o.a;}
	}
	static int V, E, N[], cnt = 0;
	static ArrayList<Integer>[] link;
	static ArrayList<Line> res = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
    	st(); link = new ArrayList[(V = in()+1)]; N = new int[V]; E = in();
        for(int i = 1; i < V; i++) link[i] = new ArrayList<>();
        for(int i = 0, a, b; i < E; i++) {st(); link[a=in()].add(b=in()); link[b].add(a);}
        br.close(); dfs(1, 0);
        Collections.sort(res);
        StringBuilder sb = new StringBuilder().append(res.size()).append("\n");
        for(Line r : res) sb.append(r.a).append(" ").append(r.b).append("\n");
        System.out.print(sb);
    }
    static int in() {return Integer.parseInt(st.nextToken());}
    static void st() throws IOException {st = new StringTokenizer(br.readLine());}
    static int dfs(int cur, int before) {
    	int min = N[cur] = ++cnt;
    	for(int next : link[cur]) {
    		if (before == next) continue;
    		if (N[next] != 0) {min = Math.min(min, N[next]); continue;}
    		int min2 = dfs(next, cur);
    		if (min2 > N[cur]) res.add(cur < next ? new Line(cur, next) : new Line(next, cur));
            min = Math.min(min, min2);
        }
    	return min;
    }
}