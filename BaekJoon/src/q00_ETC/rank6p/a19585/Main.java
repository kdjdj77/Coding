package q00_ETC.rank6p.a19585;
/*
문제
Sogang ICPC Team에는 색상 이름과 닉네임의 순서로 이여서 팀명을 지으면 ICPC 리저널에서 수상할 수 있다는 전설이 있다. 색상 이름들과 닉네임들이 주어질 때, Q개의 팀에 대해 다음 리저널에서 수상할 수 있을지 전설에 기반해 알려주는 프로그램을 작성하자.

입력
첫째 줄에는 색상의 종류 C와 닉네임의 개수 N이 주어진다. (1 ≤ C, N ≤ 4,000)

다음 C개의 줄에는 색상 이름 C개가 한 줄에 하나씩 주어진다. 색상 이름은 중복되지 않는다.

다음 N개의 줄에는 Sogang ICPC Team 구성원들의 닉네임 N개가 한 줄에 하나씩 주어진다. 닉네임도 중복되지 않는다.

다음 줄에는 팀의 개수 Q가 주어진다. (1 ≤ Q ≤ 20,000)

다음 Q개의 줄에는 팀명 Q개가 한 줄에 하나씩 주어진다. 팀명은 중복되지 않는다.

모든 색상 이름의 길이와 닉네임의 길이는 1,000글자를 넘지 않는다. 모든 팀명은 2,000글자를 넘지 않는다. 모든 문자열은 알파벳 소문자로만 이루어져 있다.

출력
팀명이 입력된 순서대로, 전설에 따라 해당 팀이 다음 리저널에서 수상할 수 있다면 Yes, 아니라면 No를 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	static class Trie {
	    boolean isEnd = false;
	    Trie[] next = new Trie[26];
	    Trie add(int n) {return next[n] = next[n] == null ? new Trie() : next[n];}
	}
    static Set<String> name = new HashSet<>();
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Trie root = new Trie();
        int C = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        while(C-- > 0) {
            Trie cur = root;
            String str = br.readLine();
            for(int i = 0, len = str.length(); i < len; i++) cur = cur.add(str.charAt(i)-97);
            cur.isEnd = true;
        }
        while(N-- > 0) name.add(br.readLine());
        int Q = Integer.parseInt(br.readLine());
        while(Q-- > 0) sb.append(res(br.readLine(), root) ? "Yes\n" : "No\n");
        System.out.print(sb);
    }
    static boolean res(String str, Trie root) {
        Trie cur = root;
        for(int i = 0, len = str.length(); i < len; i++) {
            cur = cur.next[str.charAt(i)-'a'];
            if (cur == null) return false;
            if (cur.isEnd && name.contains(str.substring(i+1))) return true;
        }
        return false;
    }
}