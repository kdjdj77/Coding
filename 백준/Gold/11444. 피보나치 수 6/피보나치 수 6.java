import java.util.Scanner;
 
public class Main {
	static long[][] A = {{1, 1},{1, 0}};
	static long D = 1000000007;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long N = s.nextLong();
		System.out.print(calc(N)[0][1]);
	}
	public static long[][] calc(long N) {
		if (N == 1) return A;
		long[][] tmp = calc(N/2);
		if (N % 2 == 0) return mult(tmp, tmp);
		else return mult(mult(tmp, tmp), A);
	}
	public static long[][] mult(long[][] a, long[][] b) {
		long[][] r = new long[2][2];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                for(int k = 0; k < 2; k++) r[i][j] += (a[i][k] * b[k][j]) % D;
                r[i][j] %= D;
            }
        }
        return r;
    }
}