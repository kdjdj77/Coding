package kakao_code_festival.a15999;

/*
문제
어느 날, 네오는 길을 걷다가 격자판 하나를 주웠다. 그 격자판은 N 행 M 열로, 각 격자는 흰색 또는 검은색으로 칠해져 있다.

네오는 이 격자판에는 분명 엄청난 비밀이 숨겨져 있을 것이라고 생각해 나중에 해독을 시도해 보기로 하였다. 아래 그림은 격자판 상태의 예시이다.



네오가 잠시 외출한 사이, 프로도는 네오의 격자판을 이리저리 살펴보았다. 얼마 뒤, 하나의 격자를 누르게 되면 자신을 포함해 그 격자와 연결된 모든 칸들의 색이 반전된다는 사실을 관찰할 수 있었다. 여기서, 두 격자가 연결되었다는 것은 두 격자 사이를 서로 같은 색이면서 변을 공유하는 격자들로만 이동하여 오갈 수 있다는 것을 뜻한다. 집으로 돌아온 네오는 프로도가 격자판의 상태를 바꿔버렸다는 것을 알고 좌절했다. 하지만 최종 상태를 알고 있기 때문에, 초기 상태를 추측할 수 있을 것이라는 희망을 가지기로 했다.

프로도는 격자판을 0번 이상 눌렀다(아직 한 번도 누르지 않은 상태일 수도 있다). 현재 각 격자의 색깔이 주어졌을 때, 격자판의 초기 상태로 가능한 경우의 수를 1,000,000,007(109 + 7)로 나눈 나머지를 구하여라. 두 격자판의 상태가 다르다는 것은, 같은 위치의 격자의 색이 다른 경우가 존재할 때로 정의한다.

입력
첫 줄에 격자판의 행의 수 N 과 열의 수 M 이 주어진다. (1 ≤ N, M ≤ 2,000)

둘째 줄부터 N 개의 줄에 걸쳐 현재 각 격자의 색을 나타내는 문자열이 주어진다.

N 개의 줄 중에서 i 번째 줄의 j 번째 문자는 i 행 j 열 격자의 색을 나타내며, 'B'인 경우 검은색, 'W'인 경우 흰색임을 나타낸다.

출력
첫 줄에 격자의 초기 상태로 가능한 경우의 수를 1,000,000,007(109 + 7)로 나눈 나머지를 출력한다.
 */

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static boolean[][] isW;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isW = new boolean[N][M];
        for(int i = 0; i < N; i++) {
        	String line = br.readLine();
        	for(int j = 0; j < M; j++) isW[i][j] = line.charAt(j) == 'W';
        }
        
        
        
    }
	static void dfs() {
		
	}
	static boolean[][] pick(boolean[][] map, int x, int y) {
		if (x > 0 && !map[x-1][y]^map[x][y]) map[x-1][y] = !map[x-1][y];
		if (y > 0 && !map[x][y-1]^map[x][y]) map[x][y-1] = !map[x][y-1];
		if (x < N-1 && !map[x+1][y]^map[x][y]) map[x+1][y] = !map[x+1][y];
		if (y < M-1 && !map[x][y+1]^map[x][y]) map[x][y+1] = !map[x][y+1];
		map[x][y] = !map[x][y];
		return map;
	}
}