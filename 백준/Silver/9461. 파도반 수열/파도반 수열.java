import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	static long[] list = new long[100];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		calc();
		int cnt = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < cnt; i++)
			sb.append(list[Integer.parseInt(br.readLine()) - 1]).append('\n');
		
		System.out.println(sb);
	}
 
	public static void calc() {
		list[0] = 1; list[1] = 1; list[2] = 1;
		for (int i = 3; i < 100; i++) 
			list[i] = list[i - 2] + list[i - 3];
	}
}