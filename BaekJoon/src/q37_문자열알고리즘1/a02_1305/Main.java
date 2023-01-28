package q37_문자열알고리즘1.a02_1305;
/*
문제
세준이는 길 한가운데에서 전광판을 쳐다보고 있었다. 전광판에는 광고가 흘러나오고 있었다. 한참을 전광판을 쳐다본 세준이는 이 광고가 의미하는 것이 무엇인지 궁금해지기 시작했다.

전광판에는 같은 내용의 문구가 무한히 반복되어 나온다. 또, 전광판의 크기는 전광판에서 한번에 보이는 최대 문자수를 나타낸다. 만약 전광판의 크기가 L이라면, 한번에 L개의 문자를 표시할 수 있는 것이다.

광고업자는 최대한의 광고효과를 내기 위해서 길이가 N인 광고를 무한히 붙여서 광고한다.

예를 들어, 광고 업자 백은진이 광고하고 싶은 내용이 aaba 이고, 전광판의 크기가 6이라면 맨 처음에 보이는 내용은 aabaaa 이다. 시간이 1초가 지날 때마다, 문자는 한 칸씩 옆으로 이동한다. 따라서 처음에 aabaaa가 보였으면 그 다음에는 abaaab가 보인다. 그 다음에는 baaaba가 보인다.

세준이가 어느 순간 전광판을 쳐다봤을 때, 그 때 쓰여 있는 문자가 입력으로 주어졌을 때, 가능한 광고의 길이중 가장 짧은 것을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 광고판의 크기 L이 주어지고, 둘째 줄에 현재 광고판에 보이는 문자열이 주어진다.

출력
첫째 줄에 가능한 광고의 길이중 가장 짧은 것의 길이를 출력한다.

제한
1 ≤ L ≤ 1,000,000
광고판에 보이는 문자열은 알파벳 소문자로만 이루어져 있다.
*/

import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int[] pi = pi(str);
		System.out.print(L - pi[L-1]);
	}
	static int[] pi(String s) {
		int idx = 0, len = s.length();
		int[] pi = new int[len];
		
		for(int i = 1; i < len; i++) {
			while(idx > 0 && s.charAt(idx) != s.charAt(i)) idx = pi[idx - 1];
			if(s.charAt(idx) == s.charAt(i)) pi[i] = ++idx;
		}
		return pi;
	}
}