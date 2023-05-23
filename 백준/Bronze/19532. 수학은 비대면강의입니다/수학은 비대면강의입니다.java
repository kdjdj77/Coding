import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n[] = new int[6], x, y;
		for(int i = 0; i < 6; i++) n[i] = Integer.parseInt(st.nextToken());
		x = n[1] == 0 ? n[2]/n[0] : n[4] == 0 ? n[5]/n[3] : (n[2]*n[4]-n[5]*n[1])/(n[0]*n[4]-n[3]*n[1]);
		y = n[0] == 0 ? n[2]/n[1] : n[3] == 0 ? n[5]/n[4] : (n[2]*n[3]-n[5]*n[0])/(n[1]*n[3]-n[4]*n[0]);
		System.out.print(sb.append(x).append(" ").append(y));
	}
}