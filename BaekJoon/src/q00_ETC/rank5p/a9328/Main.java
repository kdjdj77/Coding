package q00_ETC.rank5p.a9328;
/*
문제
상근이는 1층 빌딩에 침입해 매우 중요한 문서를 훔쳐오려고 한다. 상근이가 가지고 있는 평면도에는 문서의 위치가 모두 나타나 있다. 빌딩의 문은 모두 잠겨있기 때문에, 문을 열려면 열쇠가 필요하다. 상근이는 일부 열쇠를 이미 가지고 있고, 일부 열쇠는 빌딩의 바닥에 놓여져 있다. 상근이는 상하좌우로만 이동할 수 있다.

상근이가 훔칠 수 있는 문서의 최대 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수가 주어진다. 테스트 케이스의 수는 100개를 넘지 않는다.

각 테스트 케이스의 첫째 줄에는 지도의 높이와 너비 h와 w (2 ≤ h, w ≤ 100)가 주어진다. 다음 h개 줄에는 빌딩을 나타내는 w개의 문자가 주어지며, 각 문자는 다음 중 하나이다.

'.'는 빈 공간을 나타낸다.
'*'는 벽을 나타내며, 상근이는 벽을 통과할 수 없다.
'$'는 상근이가 훔쳐야하는 문서이다.
알파벳 대문자는 문을 나타낸다.
알파벳 소문자는 열쇠를 나타내며, 그 문자의 대문자인 모든 문을 열 수 있다.
마지막 줄에는 상근이가 이미 가지고 있는 열쇠가 공백없이 주어진다. 만약, 열쇠를 하나도 가지고 있지 않는 경우에는 "0"이 주어진다.

상근이는 처음에는 빌딩의 밖에 있으며, 빌딩 가장자리의 벽이 아닌 곳을 통해 빌딩 안팎을 드나들 수 있다. 각각의 문에 대해서, 그 문을 열 수 있는 열쇠의 개수는 0개, 1개, 또는 그 이상이고, 각각의 열쇠에 대해서, 그 열쇠로 열 수 있는 문의 개수도 0개, 1개, 또는 그 이상이다. 열쇠는 여러 번 사용할 수 있다.

출력
각 테스트 케이스 마다, 상근이가 훔칠 수 있는 문서의 최대 개수를 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final int[][] next = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int N = Integer.parseInt(br.readLine());
    	while(N-- > 0) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int h = Integer.parseInt(st.nextToken()) + 2, w = Integer.parseInt(st.nextToken()) + 2;
    		char[][] map = new char[h][w];
    		map[0] = map[h-1] = ".".repeat(w).toCharArray();
        	for(int i = 1; i < h-1; i++)
        		map[i] = new StringBuilder(".").append(br.readLine()).append(".").toString().toCharArray();
        	Set<Character> keys = new HashSet<>();
        	br.readLine().chars().mapToObj(c -> (char) c).forEach(keys::add);
    		sb.append(res(h, w, map, keys)).append("\n");
    	}
    	System.out.print(sb);
    }
    private static int res(int h, int w, char[][] map, Set<Character> keys) {
    	Queue<int[]> stop = new LinkedList<>(Arrays.asList(new int[] {0, 0})), q = new LinkedList<>();
    	boolean visit[][] = new boolean[h][w], repeat = true;
    	int res = 0;
    	while(repeat) {
    		repeat = false;
	    	while(!stop.isEmpty()) q.add(stop.poll());
	    	while(!q.isEmpty()) {
	    		int[] cur = q.poll();
	    		for(int[] n : next) {
	    			int x = cur[0]+n[0], y = cur[1]+n[1];
	    			if (x < 0 || y < 0 || x >= h || y >= w) continue;
	    			
	    			char nc = map[x][y];
	    			if (visit[x][y] || nc == '*') continue;
	    			if ('A' <= nc && nc <= 'Z' && !keys.contains((char)(nc+32))) stop.add(cur);
	    			else {
	    				visit[x][y] = repeat = true;
		    			q.add(new int[] {x, y});
		    			if ('a' <= nc) keys.add(nc);
		    			else if (nc == '$') res++;
	    			}
	    		}
	    	}
    	}
    	return res;
    }
}