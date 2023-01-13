import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
		int noon = Integer.parseInt(st.nextToken());
		int night = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(st.nextToken());
		
		int days = (len - night) / (noon - night);
		if ((len - night) % (noon - night) != 0) days++;
		System.out.println(days);
	}
}