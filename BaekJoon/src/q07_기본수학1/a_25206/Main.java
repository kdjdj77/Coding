package q07_기본수학1.a_25206;
/*
문제
월드전자는 노트북을 제조하고 판매하는 회사이다. 노트북 판매 대수에 상관없이 매년 임대료, 재산세, 보험료, 급여 등 A만원의 고정 비용이 들며, 한 대의 노트북을 생산하는 데에는 재료비와 인건비 등 총 B만원의 가변 비용이 든다고 한다.

예를 들어 A=1,000, B=70이라고 하자. 이 경우 노트북을 한 대 생산하는 데는 총 1,070만원이 들며, 열 대 생산하는 데는 총 1,700만원이 든다.

노트북 가격이 C만원으로 책정되었다고 한다. 일반적으로 생산 대수를 늘려 가다 보면 어느 순간 총 수입(판매비용)이 총 비용(=고정비용+가변비용)보다 많아지게 된다. 최초로 총 수입이 총 비용보다 많아져 이익이 발생하는 지점을 손익분기점(BREAK-EVEN POINT)이라고 한다.

A, B, C가 주어졌을 때, 손익분기점을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 21억 이하의 자연수이다.

출력
첫 번째 줄에 손익분기점 즉 최초로 이익이 발생하는 판매량을 출력한다. 손익분기점이 존재하지 않으면 -1을 출력한다.
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Map<String, Float> map = new HashMap<>();
		map.put("A+", 4.5f); map.put("A0", 4f); map.put("B+", 3.5f); map.put("B0", 3f);
		map.put("C+", 2.5f); map.put("C0", 2f); map.put("D+", 1.5f); map.put("D0", 1f);
		map.put("F", 0f);
		float s = 0, d = 0;
		for(int i = 0; i < 20; i++) {
			st = new StringTokenizer(br.readLine()); st.nextToken();
			float credit = Float.parseFloat(st.nextToken());
			String grade = st.nextToken();
			if ("P".equals(grade)) continue;
			s += credit * map.get(grade);
			d += credit;
		}
		System.out.print(s/d);
	}
}