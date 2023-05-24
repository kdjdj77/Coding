package q08_기본수학2.a_9506;
/*
문제
어떤 숫자 n이 자신을 제외한 모든 약수들의 합과 같으면, 그 수를 완전수라고 한다.

예를 들어 6은 6 = 1 + 2 + 3 으로 완전수이다.

n이 완전수인지 아닌지 판단해주는 프로그램을 작성하라.

입력
입력은 테스트 케이스마다 한 줄 간격으로 n이 주어진다. (2 < n < 100,000)

입력의 마지막엔 -1이 주어진다.

출력
테스트케이스 마다 한줄에 하나씩 출력해야 한다.

n이 완전수라면, n을 n이 아닌 약수들의 합으로 나타내어 출력한다(예제 출력 참고).

이때, 약수들은 오름차순으로 나열해야 한다.

n이 완전수가 아니라면 n is NOT perfect. 를 출력한다.
 */

import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N;
		while((N = Integer.parseInt(br.readLine())) != -1) {
			int sum = 1, idx = 1;
			double sqrt = Math.sqrt(N);
			List<String> divs = new ArrayList<>(); divs.add("1");
			for(int i = 2; i < sqrt; i++) {
				if (N%i != 0) continue;
				sum += i + N/i;
				divs.add(idx, String.valueOf(N/i));
				divs.add(idx++, String.valueOf(i));
			} if (sqrt % 1 == 0) divs.add(idx, String.valueOf((int)sqrt));
			sb.append(N);
			if (sum != N) sb.append(" is NOT perfect.\n");
			else sb.append(" = ").append(String.join(" + ", divs)).append("\n");
		}
		System.out.print(sb);
	}
}