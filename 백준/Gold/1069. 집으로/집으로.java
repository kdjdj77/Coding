import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		double res = 0;
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		double dist = Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
		
		if (D < T) res = dist;
		else {
			int jump = (int)(dist / D);
			double left = dist - D*jump;
			
			double jw = left + T*jump++;
			double jjw = D*jump - dist + T*jump;
			double jj = jump * (double)T;
			res = Math.min(jw, jjw);
			
			if (jump > 1) res = Math.min(res, jj);
			else if(dist < D) res = Math.min(res, 2.0*T);
		}
		System.out.print(res);
	}	
}