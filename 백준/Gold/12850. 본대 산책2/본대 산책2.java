import java.io.*;

public class Main {
    static int MOD = 1000000007, begin[] = {0,1,1,0,0,0,0,0};
    static long[][][] bin = new long[32][8][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int D = Integer.parseInt(br.readLine())-1;
        
        byte[][] link = {{0,1},{0,2},{1,2},{1,3},{2,3},{2,4},{3,4},{3,5},{4,5},{4,6},{5,7},{6,7}};
        for(byte[] l : link) {bin[0][l[0]][l[1]] = 1; bin[0][l[1]][l[0]] = 1;}
        
        long[][] total = new long[8][8];
        for(int i = 0; i < 8; i++) total[i][i] = 1;
        for(int i = 1; i < 32; i++) bin[i] = mult(bin[i-1], bin[i-1]);
        for(int i = 0; 1<<i < D; i++) if ((D & 1<<i) != 0) total = mult(total, bin[i]);
        System.out.print(res(begin, total)[0]);
    }
    static long[][] mult(long[][] a, long[][] b) {
        long[][] res = new long[8][8];
        for(int i = 0, x, y; i < 64; i++) for(int k = 0; k < 8; k++)
            res[x=i/8][y=i%8] = (res[x][y] += a[x][k]*b[k][y]) % MOD;
        return res;
    }
    static int[] res(int[] a, long[][] b) {
        int[] res = new int[8];
        for(int i = 0, x, y; i < 64; i++) res[x=i/8] = (res[x] += a[y=i%8]*b[x][y]) % MOD;
        return res;
    }
}