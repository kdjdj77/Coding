import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	static int cnt;
	static int[][] power;
	static boolean[] isTeamStart;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		cnt = Integer.parseInt(br.readLine());
		power = new int[cnt][cnt];
		isTeamStart = new boolean[cnt];
 
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < cnt; j++) power[i][j] = Integer.parseInt(st.nextToken());
		}
		combi(0, 0);
		System.out.println(min);
	}
	static void combi(int start, int depth) {
		if(depth == cnt / 2) { diff(); return; }
		for(int i = start; i < cnt; i++) {
			if(!isTeamStart[i]) {
				isTeamStart[i] = true;
				combi(i + 1, depth + 1);
				isTeamStart[i] = false;
			}
		}
	}
	static void diff() {
		int sum1 = 0, sum2 = 0;
 
		for (int i = 0; i < cnt - 1; i++) {
			for (int j = i + 1; j < cnt; j++) {
				if (isTeamStart[i] && isTeamStart[j]) sum1 += power[i][j] + power[j][i];
				if (!isTeamStart[i] && !isTeamStart[j]) sum2 += power[i][j] + power[j][i];
			}
		}
		min = Math.min(Math.abs(sum1 - sum2), min);
	}
}