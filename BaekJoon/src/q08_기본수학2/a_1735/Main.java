package q08_기본수학2.a_1735;
/*
문제
분수 A/B는 분자가 A, 분모가 B인 분수를 의미한다. A와 B는 모두 자연수라고 하자.

두 분수의 합 또한 분수로 표현할 수 있다. 두 분수가 주어졌을 때, 그 합을 기약분수의 형태로 구하는 프로그램을 작성하시오. 기약분수란 더 이상 약분되지 않는 분수를 의미한다.

입력
첫째 줄과 둘째 줄에, 각 분수의 분자와 분모를 뜻하는 두 개의 자연수가 순서대로 주어진다. 입력되는 네 자연수는 모두 30,000 이하이다.

출력
첫째 줄에 구하고자 하는 기약분수의 분자와 분모를 뜻하는 두 개의 자연수를 빈 칸을 사이에 두고 순서대로 출력한다.
 */

import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) pq.add(Integer.parseInt(br.readLine()));
        
        int gcd = 0, s = pq.peek();
        for(int i = 0; i < N-1; i++) gcd = gcd(-pq.poll() + pq.peek(), gcd);
        System.out.print((pq.poll() - s) / gcd - N + 1);
    }
    private static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a%b); }
}