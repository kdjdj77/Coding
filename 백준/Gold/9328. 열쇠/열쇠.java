import java.io.*;
import java.util.*;

public class Main {
	private static int h, w;
	private static final int[][] next = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine());
    	while(N-- > 0) {
    		st = new StringTokenizer(br.readLine());
    		h = Integer.parseInt(st.nextToken()) + 2;
    		w = Integer.parseInt(st.nextToken()) + 2;
    		
    		char[][] map = new char[h][w];
    		map[0] = map[h-1] = ".".repeat(w).toCharArray();
        	for(int i = 1; i < h-1; i++)
        		map[i] = new StringBuilder().append(".").append(br.readLine()).append(".").toString().toCharArray();
        	Set<Character> keys = new HashSet<>();
        	br.readLine().chars().mapToObj(c -> (char) c).forEach(keys::add);
    		sb.append(res(0, 0, map, keys)).append("\n");
    	}
    	System.out.print(sb);
    }
    private static int res(int x, int y, char[][] map, Set<Character> keys) {
    	int res = 0;
    	Queue<int[]> stop = new LinkedList<>(), q = new LinkedList<>();
    	boolean[][] visit = new boolean[h][w];
    	stop.add(new int[] {x, y});
    	visit[0][0] = true;
    	
    	boolean repeat = true;
    	while(repeat) {
    		repeat = false;
	    	while(!stop.isEmpty()) q.add(stop.poll());
	    	while(!q.isEmpty()) {
	    		int[] cur = q.poll();
	    		for(int[] n : next) {
	    			int x2 = cur[0] + n[0], y2 = cur[1] + n[1];
	    			if (x2 < 0 || y2 < 0 || x2 >= h || y2 >= w) continue;
	    			
	    			char nc = map[x2][y2];
	    			if (visit[x2][y2] || nc == '*') continue;
	    			if ('A' <= nc && nc <= 'Z' && !keys.contains((char)(nc+32))) {
						stop.add(new int[] {cur[0], cur[1]});
						continue;
	    			}
	    			visit[x2][y2] = repeat = true;
	    			q.add(new int[] {x2, y2});
	    			if ('a' <= nc && nc <= 'z') keys.add(nc);
	    			if (nc == '$') res++;
	    		}
	    	}
    	}
    	return res;
    }
}