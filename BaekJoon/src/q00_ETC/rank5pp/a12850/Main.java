package q00_ETC.rank5pp.a12850;
/*
문제
숭실 대학교 정보 과학관은 유배를 당해서  캠퍼스의 길 건너편에 있다. 그래서 컴퓨터 학부 학생들은 캠퍼스를 ‘본대’ 라고 부르고 정보 과학관을 ‘정보대’ 라고 부른다. 준영이 또한 컴퓨터 학부 소속 학생이라서 정보 과학관에 박혀있으며 항상 꽃 이 활짝 핀 본 대를 선망한다. 어느 날 준영이는 본 대를 산책하기로 결심하였다. 숭실 대학교 캠퍼스 지도는 아래와 같다.



(편의 상 문제에서는 위 건물만 등장한다고 가정하자)

한 건물에서 바로 인접한 다른 건물로 이동 하는 데 1분이 걸린다. 준영이는 산책 도중에 한번도 길이나 건물에 멈춰서 머무르지 않는다. 준영이는 할 일이 많아서 딱 D분만 산책을 할 것이다. (산책을 시작 한 지 D분 일 때, 정보 과학관에 도착해야 한다.) 이때 가능한 경로의 경우의 수를 구해주자.

입력
D 가 주어진다 (1 ≤ D ≤ 1,000,000,000) 

출력
가능한 경로의 수를 1,000,000,007로 나눈 나머지를 출력한다
*/

import java.io.*;

public class Main {
    static int MOD = 1000000007, begin[] = {0,1,1,0,0,0,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int D = Integer.parseInt(br.readLine())-1, res[] = new int[8];
        long total[][] = new long[8][8], bin[][][] = new long[32][8][8];
        byte link[][] = {{0,1},{0,2},{1,2},{1,3},{2,3},{2,4},{3,4},{3,5},{4,5},{4,6},{5,7},{6,7}};
        
        for(byte[] l : link) bin[0][l[0]][l[1]] = bin[0][l[1]][l[0]] = 1;
        for(int i = 0; i < 8; i++) total[i][i] = 1;
        for(int i = 1; i < 32; i++) bin[i] = mult(bin[i-1], bin[i-1]);
        for(int i = 0; 1<<i < D; i++) if ((D & 1<<i) != 0) total = mult(total, bin[i]);
        for(int i = 0, x, y; i < 64; i++) res[x=i/8] = (res[x] += begin[y=i%8]*total[x][y]) % MOD;
        System.out.print(res[0]);
    }
    static long[][] mult(long[][] a, long[][] b) {
        long[][] res = new long[8][8];
        for(int i = 0, x, y; i < 64; i++) for(int k = 0; k < 8; k++)
            res[x=i/8][y=i%8] = (res[x][y] += a[x][k]*b[k][y]) % MOD;
        return res;
    }
}