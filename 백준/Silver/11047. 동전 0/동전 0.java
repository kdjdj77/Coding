import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken());
		int price = Integer.parseInt(st.nextToken());
		int[] list = new int[cnt];
		int res = 0;
		for(int i = 0; i < cnt; i++) {
			list[cnt-i-1] = Integer.parseInt(br.readLine());
		}
		for(int i = 0; i < cnt; i++) {
			if (price / list[i] > 0) {
				res += price / list[i];
				price %= list[i];
			}
			if (price == 0) break;
		}
		System.out.print(res);
	}
}