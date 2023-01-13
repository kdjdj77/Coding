package q02_조건문.a02_9498;
/*
시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 
나머지 점수는 F를 출력하는 프로그램을 작성하시오
*/

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		char res;
		
		switch(a / 10) {
			case 10:
			case 9: res = 'A'; break;
			case 8: res = 'B'; break;
			case 7: res = 'C'; break;
			case 6: res = 'D'; break;
			default: res = 'F';
		}
		System.out.print(res);
	}
}
