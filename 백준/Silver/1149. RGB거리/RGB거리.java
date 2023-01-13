import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main { 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt = Integer.parseInt(br.readLine());
 
		int[][] list = new int[cnt][3];
 
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
			list[i][2] = Integer.parseInt(st.nextToken());
		}
		System.out.print(calc(list, cnt));
	}
	public static int calc(int[][] list, int cnt) {
		for (int i = 1; i < cnt; i++) {
			list[i][0] += Math.min(list[i - 1][1], list[i - 1][2]);
			list[i][1] += Math.min(list[i - 1][0], list[i - 1][2]);
			list[i][2] += Math.min(list[i - 1][0], list[i - 1][1]);
		}
		return Math.min(Math.min(list[cnt - 1][0], list[cnt - 1][1]), list[cnt - 1][2]);
	}
}