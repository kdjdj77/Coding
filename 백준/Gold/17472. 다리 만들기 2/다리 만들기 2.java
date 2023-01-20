import java.io.*;
import java.util.*;

class Road implements Comparable<Road> {
	int l, r, w;
	public Road(int l, int r, int w) {
		this.l = l;
		this.r = r;
		this.w = w;
	}
	@Override
	public int compareTo(Road n) {
		return this.w - n.w;
	}
}
public class Main {
	static int N, M;
	static int[] A;
	static int[][] map;
	static int number = 2;
	static ArrayList<Road> roads = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < N; i++) for(int j = 0; j < M; j++) if (setIsland(i, j)) number++;
		
		setRoads();
		Collections.sort(roads);
		A = new int[number];
		for(int i = 2; i < number; i++) A[i] = i;
		
		int res = 0;
		for(Road r : roads) if (!isSameRoot(r.l, r.r)) { union(r.l, r.r); res += r.w; }
		
		for(int i = 3; i < number; i++) if (!isSameRoot(2, i)) { res = -1; break; }
		System.out.print(res);
	}
	public static boolean setIsland(int v, int h) {
		if (v < 0 || v >= N || h < 0 || h >= M) return false;
		if (map[v][h] == 0 || map[v][h] > 1) return false;
		
		map[v][h] = number;
		setIsland(v-1, h);
		setIsland(v+1, h);
		setIsland(v, h-1);
		setIsland(v, h+1);

		return true;
	}
	public static void setRoads() {
		for(int i = 0; i < N; i++) {
			int cur = map[i][0], len = 0;
			for(int j = 0; j < M; j++) {
				if (map[i][j] == 0) { len++; continue; }
				if (map[i][j] == cur) { len = 0; continue; }

				if (len > 1 && cur != 0) roads.add(new Road(map[i][j], cur, len));
				cur = map[i][j]; len = 0;
			}
		}
		for(int i = 0; i < M; i++) {
			int cur = map[0][i], len = 0;
			for(int j = 0; j < N; j++) {
				if (map[j][i] == 0) { len++; continue; }
				if (map[j][i] == cur) { len = 0; continue; }
				
				if (len > 1 && cur != 0) roads.add(new Road(map[j][i], cur, len));
				cur = map[j][i]; len = 0;
			}
		}
	}
	public static int root(int x) {
        if(x == A[x]) return x;
        return A[x] = root(A[x]);
	}
    public static void union(int x, int y) {
        x = root(x); y = root(y);
        if (x == y) return;
        if (x < y) A[y] = x;
        else A[x] = y;
    }
    public static boolean isSameRoot(int x, int y) {
        return root(x) == root(y);
    }
}