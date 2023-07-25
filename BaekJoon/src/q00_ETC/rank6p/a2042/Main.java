package q00_ETC.rank6p.a2042;
/*
문제
어떤 N개의 수가 주어져 있다. 그런데 중간에 수의 변경이 빈번히 일어나고 그 중간에 어떤 부분의 합을 구하려 한다. 만약에 1,2,3,4,5 라는 수가 있고, 3번째 수를 6으로 바꾸고 2번째부터 5번째까지 합을 구하라고 한다면 17을 출력하면 되는 것이다. 그리고 그 상태에서 다섯 번째 수를 2로 바꾸고 3번째부터 5번째까지 합을 구하라고 한다면 12가 될 것이다.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)과 M(1 ≤ M ≤ 10,000), K(1 ≤ K ≤ 10,000) 가 주어진다. M은 수의 변경이 일어나는 횟수이고, K는 구간의 합을 구하는 횟수이다. 그리고 둘째 줄부터 N+1번째 줄까지 N개의 수가 주어진다. 그리고 N+2번째 줄부터 N+M+K+1번째 줄까지 세 개의 정수 a, b, c가 주어지는데, a가 1인 경우 b(1 ≤ b ≤ N)번째 수를 c로 바꾸고 a가 2인 경우에는 b(1 ≤ b ≤ N)번째 수부터 c(b ≤ c ≤ N)번째 수까지의 합을 구하여 출력하면 된다.

입력으로 주어지는 모든 수는 -2^63보다 크거나 같고, 2^63-1보다 작거나 같은 정수이다.

출력
첫째 줄부터 K줄에 걸쳐 구한 구간의 합을 출력한다. 단, 정답은 -2^63보다 크거나 같고, 2^63-1보다 작거나 같은 정수이다.
*/

import java.io.*;
import java.util.*;

public class Main {
	static int L;
	static long[] num;
    public static void main(String[] args) throws IOException {
    	Reader fr = new Reader();
    	int N = fr.ni(), M = fr.ni(), K = fr.ni();
    	num = new long[L = (N<<1)];
    	for(int i = N; i < L; i++) num[i] = fr.ni();
    	set(1);
    	for(int i = 0; i < M+K; i++) {
    		int a = fr.ni(), b = fr.ni();
    		if (a == 1) {
    			long c = fr.nl();
    			
    		} else {
    			int c = fr.ni();
    			
    		}
    	}
    }
    static long set(int cur) {return L <= cur ? 0 : (num[cur] = set(cur<<1) + set((cur<<1)+1));}
    static void update(int cur) {
    	if (cur < 2) return;
    	
    }
}
class Reader {
	BufferedReader br; StringTokenizer st;
    Reader(){br=new BufferedReader(new InputStreamReader(System.in));}
    String ns(){if(st==null||!st.hasMoreTokens())try{st=new StringTokenizer(br.readLine());}catch(IOException e){}return st.nextToken();}
    int ni(){return Integer.parseInt(ns());}
    long nl(){return Long.parseLong(ns());}
}