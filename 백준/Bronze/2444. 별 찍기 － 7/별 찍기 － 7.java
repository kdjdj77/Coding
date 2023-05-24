import java.io.*;

public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int k = N-1; k >= 0; k--) set(k, N);
		for(int k = 1; k < N; k++) set(k, N);
        System.out.print(sb);
	}
    private static void set(int k, int N) {
    	int len = N*2-1;
    	for(int i = 0; i < k; i++) sb.append(" ");
		for(int i = 0; i < len-2*k; i++) sb.append("*");
		sb.append("\n");
    }
}