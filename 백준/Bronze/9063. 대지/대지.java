import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] sq = new int[][] {{10000,-10000},{10000,-10000}};
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 2; i++) {
				int x = Integer.parseInt(st.nextToken());
				if (x < sq[i][0]) sq[i][0] = x;
				if (x > sq[i][1]) sq[i][1] = x;
			}
		}
		System.out.print(Math.abs(sq[0][0]-sq[0][1]) * Math.abs(sq[1][0]-sq[1][1]));
	}
}