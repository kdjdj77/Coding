package q35_기하2.a09_1069;
/*
문제
은진이는 지금 (X, Y)에 있고, (0, 0)에 있는 집으로 가능한 빨리 가려고 한다. 이동할 수 있는 방법은 다음 두 가지이다.

첫 번째 방법은 걷는것이다. 걸을 때는 1초에 1만큼 움직인다. 두 번째 방법은 점프하는 것이다. 점프를 하게 되면, T초에 D만큼 움직인다. 점프는 일직선으로만 할 수 있고, 정확하게 D칸만 움직일 수 있다.

위의 두 가지 방법을 이용해서 집에 돌아오는데 걸리는 시간의 최솟값을 구하는 프로그램을 작성하시오. 꼭 한 가지 방법만 사용해야 되는것이 아니고, 두 가지 방법을 적절히 조합해서 가장 빠른 시간을 구하는 것이다.

입력
첫째 줄에 네 정수 X, Y, D, T가 주어진다.

출력
첫째 줄에 집에 돌아오는데 걸리는 시간의 최솟값을 출력한다. 절대/상대 오차는 10-9까지 허용한다.
*/

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