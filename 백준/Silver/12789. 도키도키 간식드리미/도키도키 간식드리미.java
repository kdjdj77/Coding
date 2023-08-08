import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), n = 1, S[] = new int[1001], i = -1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(N-- > 0) {
			while(i >= 0 && S[i] == n) {i--; n++;}
			S[++i] = Integer.parseInt(st.nextToken());
		}
		while(i >= 0 && S[i] == n) {i--; n++;}
		System.out.print(i == -1 ? "Nice" : "Sad");
	}
}