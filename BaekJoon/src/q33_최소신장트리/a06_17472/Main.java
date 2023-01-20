package q33_최소신장트리.a06_17472;
/*
문제
섬으로 이루어진 나라가 있고, 모든 섬을 다리로 연결하려고 한다. 이 나라의 지도는 N×M 크기의 이차원 격자로 나타낼 수 있고, 격자의 각 칸은 땅이거나 바다이다.

섬은 연결된 땅이 상하좌우로 붙어있는 덩어리를 말하고, 아래 그림은 네 개의 섬으로 이루어진 나라이다. 색칠되어있는 칸은 땅이다.



다리는 바다에만 건설할 수 있고, 다리의 길이는 다리가 격자에서 차지하는 칸의 수이다. 다리를 연결해서 모든 섬을 연결하려고 한다. 섬 A에서 다리를 통해 섬 B로 갈 수 있을 때, 섬 A와 B를 연결되었다고 한다. 다리의 양 끝은 섬과 인접한 바다 위에 있어야 하고, 한 다리의 방향이 중간에 바뀌면 안된다. 또, 다리의 길이는 2 이상이어야 한다.

다리의 방향이 중간에 바뀌면 안되기 때문에, 다리의 방향은 가로 또는 세로가 될 수 밖에 없다. 방향이 가로인 다리는 다리의 양 끝이 가로 방향으로 섬과 인접해야 하고, 방향이 세로인 다리는 다리의 양 끝이 세로 방향으로 섬과 인접해야 한다.

섬 A와 B를 연결하는 다리가 중간에 섬 C와 인접한 바다를 지나가는 경우에 섬 C는 A, B와 연결되어있는 것이 아니다. 

아래 그림은 섬을 모두 연결하는 올바른 2가지 방법이고, 다리는 회색으로 색칠되어 있다. 섬은 정수, 다리는 알파벳 대문자로 구분했다.

	
다리의 총 길이: 13

D는 2와 4를 연결하는 다리이고, 3과는 연결되어 있지 않다.

다리의 총 길이: 9 (최소)

다음은 올바르지 않은 3가지 방법이다

		
C의 방향이 중간에 바뀌었다	D의 길이가 1이다.	가로 다리인 A가 1과 가로로 연결되어 있지 않다.
다리가 교차하는 경우가 있을 수도 있다. 교차하는 다리의 길이를 계산할 때는 각 칸이 각 다리의 길이에 모두 포함되어야 한다. 아래는 다리가 교차하는 경우와 기타 다른 경우에 대한 2가지 예시이다.

	
A의 길이는 4이고, B의 길이도 4이다.

총 다리의 총 길이: 4 + 4 + 2 = 10

다리 A: 2와 3을 연결 (길이 2)

다리 B: 3과 4를 연결 (길이 3)

다리 C: 2와 5를 연결 (길이 5)

다리 D: 1과 2를 연결 (길이 2)

총 길이: 12

나라의 정보가 주어졌을 때, 모든 섬을 연결하는 다리 길이의 최솟값을 구해보자.

입력
첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어진다. 둘째 줄부터 N개의 줄에 지도의 정보가 주어진다. 각 줄은 M개의 수로 이루어져 있으며, 수는 0 또는 1이다. 0은 바다, 1은 땅을 의미한다.

출력
모든 섬을 연결하는 다리 길이의 최솟값을 출력한다. 모든 섬을 연결하는 것이 불가능하면 -1을 출력한다.

제한
1 ≤ N, M ≤ 10
3 ≤ N×M ≤ 100
2 ≤ 섬의 개수 ≤ 6
*/

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