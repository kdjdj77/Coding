import java.io.*;
import java.util.*;

public class Main {
	private static final int fin = 123456780;
	private static Map<Integer, Integer> dp;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] pan = new int[3][3];
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) pan[i][j] = Integer.parseInt(st.nextToken());
		}
		bfs(pan);
		System.out.print(dp.containsKey(fin) ? dp.get(fin) : -1);
    }
    private static void bfs(int[][] pan) {
    	dp = new HashMap<>();
		dp.put(arr2int(pan), 0);
    	Queue<int[][]> q = new LinkedList<>();
    	q.add(pan);
    	while(!q.isEmpty()) {
    		if (dp.containsKey(fin)) return;
    		
    		int cur[][] = q.poll();
    		int curKey = arr2int(cur);
    		int pos0[] = pos(cur), x1 = pos0[0], y1 = pos0[1];

	    	for(int[] move : new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
	    		int x2 = x1 + move[0], y2 = y1 + move[1];
	    		if (x2 < 0 || y2 < 0 || x2 > 2 || y2 > 2) continue;

	    		int[][] next = swap(cur, x1, y1, x2, y2);
	    		int nextKey = arr2int(next);
	    		
	    		if (dp.containsKey(nextKey)) continue;
	    		dp.put(nextKey, dp.get(curKey) + 1);
	    		q.add(next);
	    	}
    	}
    }
    private static int[][] swap(int[][] arr, int x1, int y1, int x2, int y2) {
    	int[][] res = new int[3][3];
    	for(int i = 0; i < 9; i++) res[i/3][i%3] = arr[i/3][i%3];
    	
    	int tmp = res[x1][y1];
    	res[x1][y1] = res[x2][y2];
    	res[x2][y2] = tmp;
    	return res;
    }
    private static int arr2int(int[][] arr) {
    	int n = 100000000, res = 0;
    	for(int i = 0; i < 9; i++) {
    		res += arr[i/3][i%3] * n;
    		n /= 10;
    	}
    	return res;
    }
    private static int[] pos(int[][] a) {
    	for(int i = 0; i < 3; i++)
    		for(int j = 0; j < 3; j++)
    			if (a[i][j] == 0) return new int[] {i, j};
    	return null;
    }
}