package q14기하1_06;
/*
문제
조규현과 백승환은 터렛에 근무하는 직원이다. 하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다. 다음은 조규현과 백승환의 사진이다.



이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다. 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.

조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고, 조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때, 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 이루어져 있다.

한 줄에 x1, y1, r1, x2, y2, r2가 주어진다. x1, y1, x2, y2는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이고, r1, r2는 10,000보다 작거나 같은 자연수이다.

출력
각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다. 만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.
*/

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cnt = s.nextInt();
 
		for(int i = 0; i < cnt; i++) {
			int x1 = s.nextInt(), y1 = s.nextInt(), r1 = s.nextInt();
			int x2 = s.nextInt(), y2 = s.nextInt(), r2 = s.nextInt();
			System.out.println(chkpoint(x1, y1, r1, x2, y2, r2));
		}
		s.close();
	}
	public static int chkpoint(int x1, int y1, int r1, int x2, int y2, int r2) {
		int sDist = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		Double mp = Math.pow(r2 - r1, 2);
		Double pp = Math.pow(r2 + r1, 2);
		
		if(x1 == x2 && y1 == y2 && r1 == r2) return -1;
		else if(sDist > pp || sDist < mp) return 0;
		else if(sDist == mp || sDist == pp) return 1;
		else return 2;
	}
}