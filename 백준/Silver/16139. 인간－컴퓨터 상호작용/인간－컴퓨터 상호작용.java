import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		String str = br.readLine();
		int len = str.length();
		int[][] list = new int[len][26];
		list[0][(int)str.charAt(0) - 97]++;
		for(int i = 1; i < len; i++) {
			for(int j = 0; j < 26; j++) list[i][j] = list[i - 1][j];
			int idx = (int)str.charAt(i) - 97;
			list[i][idx]++;
		}
		int cnt = Integer.parseInt(br.readLine());
		for(int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = (int)st.nextToken().charAt(0) - 97;
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (start == 0) sb.append(list[end][idx]);
			else sb.append(list[end][idx] - list[start - 1][idx]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}