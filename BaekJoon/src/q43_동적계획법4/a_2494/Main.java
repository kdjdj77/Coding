package q43_동적계획법4.a_2494;
/*
문제
아래 그림과 같이 N개의 회전이 가능한 숫자 나사가 아래위로 연결되어 있다. 가장 위에 있는 숫자나사는 숫자나사 1이고 가장 아래에 있는 숫자나사는 숫자나사 N이다. 모든 숫자나사는 각각 10개의 면을 가지고 있고, 각 면에는 오른쪽 방향으로 0, 1, 2, 3, …, 9까지의 숫자가 하나씩 순서대로 적혀 있다. 하나의 숫자나사를 왼쪽으로 회전 시키면, 이 나사보다 아래에 위치한 모든 나사는 같이 따라서 돌게 되지만, 나사를 오른쪽으로 회전시키면, 다른 나사는 함께 돌지는 않는다. 정면에서 보아 위에서부터 아래쪽으로 숫자를 읽어 내려간다고 할 때, 현재의 상태에서 가장 적은 칸수의 움직임으로 원하는 숫자를 만들기 위한 방법을 출력하는 프로그램을 작성하라.

예를 들어 세 개의 숫자나사가 주어졌을 때, 정면에서 보는 현재 상태가 326이고 원하는 상태는 446이라면 최소 회전 칸수는 4이다. 먼저 숫자나사 1을 왼쪽으로 한 칸 돌리면 437이 되고, 숫자나사 2를 역시 왼쪽으로 한 칸 돌리면 448이 되며, 마지막으로 숫자나사 3을 오른쪽으로 두 칸 돌리면 446이 된다.



입력
첫째 줄에는 숫자나사의 개수 N이 주어지고, 둘째 줄에는 현재의 상태가, 셋째 줄에는 원하는 상태가 주어진다. N은 3 이상이고 10,000 이하이다.

출력
첫째 줄에는 현재 상태에서 원하는 상태로 도달하는데 필요한 최소 회전 칸수를 출력한다. 다음 줄부터는 회전 순서대로 각 줄에 하나의 숫자나사 번호와 회전 칸수를 빈칸을 사이에 두고 출력한다. 회전 칸수는 왼쪽을 기준으로 하여 출력한다. 만일 왼쪽으로 4칸 회전한다면 4를, 오른쪽으로 3칸 회전한다면 -3을 출력한다. 답이 여러 개이면 그 중에 하나만 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
        int n = Integer.parseInt(br.readLine()), dp[][] = new int[n+1][10];
        String a = br.readLine(), b = br.readLine();
        while(n-- > 0) {
        	for(int i = 0; i < 10; i++) {
	        	int numA = a.charAt(n)-'0', numB = b.charAt(n)-'0';
	        	
	        	
	            int spin = (numA + 10 - ((numB + i) % 10)) % 10;
	            dp[n][i] = Math.min(dp[n+1][(spin+i)%10]+spin, dp[n+1][i]+10-spin);
            }
        	
        }
        System.out.print(dp[0][0]);
		
		
	}	
}