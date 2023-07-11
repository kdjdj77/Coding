import java.io.*;

public class Main {
	static int cnt[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int s = 1, e = Integer.parseInt(br.readLine()), len = 1;
		cnt = new int[10];
		while(s <= e) {
			while(s%10 != 0 && s <= e) cnt(s++, len);
			while(e%10 != 9 && s <= e) cnt(e--, len);
			if(s > e) break;
			s /= 10; e /= 10;
			for(int i = 0; i < 10; i++) cnt[i] += (e-s+1)*len;
			len *= 10;
		}
		StringBuilder sb = new StringBuilder();
		for(int i : cnt) sb.append(i).append(" ");
		System.out.print(sb);
	}
	static void cnt(int n, int len) {while(n > 0) {cnt[n%10] += len; n /= 10;}}
}