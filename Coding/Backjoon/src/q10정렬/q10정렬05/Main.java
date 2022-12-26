package q10정렬05;
/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    public static void main(String[] args) throws IOException {
        int[] numCnt = new int[10001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num;

        for (int i = 0; i < N; i++) {
        	num = Integer.parseInt(br.readLine());
        	numCnt[num]++;
        }
 
        StringBuilder str = new StringBuilder();
 
        for(int i = 1; i < 10001; i++){
            for(int j = 0; j < numCnt[i]; j++) {
                str.append(i);
                str.append('\n');
            }
        }
        System.out.println(str);
    }
}