package q30_동적계획법과최단거리역추적.a04_9252;
/*
문제
LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 
모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

입력
첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.

출력
첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를, 둘째 줄에 LCS를 출력한다.

LCS가 여러 가지인 경우에는 아무거나 출력하고, LCS의 길이가 0인 경우에는 둘째 줄을 출력하지 않는다.
*/

import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String str1 = br.readLine(), str2 = br.readLine();
		int a = str1.length(), b = str2.length();
		
		int[][] lcs = new int[a+1][b+1];
		for(int i = 0; i < a; i++) {
			for(int j = 0; j < b; j++) {
				if(str1.charAt(i) == str2.charAt(j)) lcs[i+1][j+1] = lcs[i][j] + 1;	 
				else lcs[i+1][j+1] = Math.max(lcs[i][j+1], lcs[i+1][j]);
			}
		}
		int res = lcs[a][b];
		sb.append(res).append("\n");
		if (res > 0) {
			char[] s = new char[res+1];
			while(a != 0 && b != 0) {
				if(lcs[a-1][b] == lcs[a][b]) a--;
				else if(lcs[a][b-1] == lcs[a][b]) b--;
				else if(str1.charAt(--a) == str2.charAt(--b)) s[--res] = str1.charAt(a);
			}
			for(char c : s) sb.append(c);
		}
		System.out.print(sb);
	}
}