package q84021;

/*

*/

import java.util.*;

class Solution {
	private int N, M;
	private int move[][] = new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
	private boolean[][] visit, tmpBlock;
    public int solution(int[][] game_board, int[][] table) {
    	int res = 0;
    	N = table.length;
    	M = table[0].length;
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++)
    			game_board[i][j] = game_board[i][j] == 0 ? 1 : 0;
    	
    	Map<Integer, ArrayList<boolean[][]>> mapA = split(table);
    	Map<Integer, ArrayList<boolean[][]>> mapB = split(game_board);
    	
    	for(int i = 1; i < 7; i++)
    		res += count(i, mapA.get(i), mapB.get(i));

        return res;
    }
    private Map<Integer, ArrayList<boolean[][]>> split(int[][] table) {
    	Map<Integer, ArrayList<boolean[][]>> map = new HashMap<>();
    	for(int i = 1; i < 7; i++) map.put(i, new ArrayList<>());
    	visit = new boolean[N][M];
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			tmpBlock = new boolean[N][M];
    			if (!searchTable(i, j, table)) continue;
    			boolean[][] block = cut(tmpBlock);
    			int cnt = 0;
    			for(boolean[] a : block) for(boolean b : a) if (b) cnt++;
    			map.get(cnt).add(block);
    		}
    	}
    	return map;
    }
    private boolean searchTable(int x, int y, int[][] t) {
    	if (visit[x][y] || t[x][y] == 0) return false;
    	visit[x][y] = true;
    	tmpBlock[x][y] = true;
    	for(int[] com : move) {
    		int curX = x+com[0], curY = y+com[1];
    		if (curX < 0 || curX >= N || curY < 0 || curY >= M) continue;
    		searchTable(curX, curY, t);
    	}
    	return true;
    }
    private boolean[][] cut(boolean[][] b) {
    	int minX = 100, maxX = -1, minY = 100, maxY = -1;
    	for(int i = 0; i < b.length; i++)
    		for(int j = 0; j < b[0].length; j++)
    			if (b[i][j]) {
    				minX = Math.min(minX, i);
    				minY = Math.min(minY, j);
    				maxX = Math.max(maxX, i);
    				maxY = Math.max(maxY, j);
    			}
    	int dx = maxX-minX+1, dy = maxY-minY+1;
    	boolean[][] res = new boolean[dx][dy];
    	for(int i = 0; i < dx; i++)
    		for(int j = 0; j < dy; j++)
    			res[i][j] = b[i+minX][j+minY];
    	return res;
    }
    private int count(int c, ArrayList<boolean[][]> a, ArrayList<boolean[][]> b) {
    	int res = 0;
    	boolean[] visit = new boolean[b.size()];
    	
    	Loop1:
    	for(boolean[][] cur : a) {
    		for(int i = 0; i < visit.length; i++) {
    			boolean[][] tmp = b.get(i);
    			
    			for(int k = 0; k < 4; k++) {
    				tmp = r(tmp);
    				if (visit[i] || !same(cur, tmp)) continue;
					visit[i] = true;
					res += c;
					continue Loop1;
    			}
    		}
    	}
    	return res;
    }
    private boolean same(boolean[][] a, boolean[][] b) {
    	if (a.length != b.length || a[0].length != b[0].length) return false;
    	for(int i = 0; i < a.length; i++)
    		for(int j = 0; j < a[0].length; j++)
    			if (a[i][j] != b[i][j]) return false;
    	return true;
    }
    static boolean[][] r(boolean[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        boolean[][] rotate = new boolean[m][n];

        for (int i = 0; i < rotate.length; i++)
            for (int j = 0; j < rotate[i].length; j++)
                rotate[i][j] = arr[n-1-j][i];
        return rotate;
    }
}