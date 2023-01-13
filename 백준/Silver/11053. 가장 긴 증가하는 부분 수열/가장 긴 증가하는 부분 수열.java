import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt = Integer.parseInt(br.readLine());
		int[] list = new int[cnt], len = new int[cnt];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < cnt; i++) list[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < cnt; i++) {
			len[i] = 1;
			for(int j = 0; j < i; j++) 
				if(list[j] < list[i] && len[i] <= len[j])
					len[i] = len[j] + 1;
		}
		int max = 0;
		for(int i = 0; i < cnt; i++) max = len[i] > max ? len[i] : max;
		System.out.println(max);
	}
}