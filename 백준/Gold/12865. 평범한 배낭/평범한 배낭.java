import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken());
		int power = Integer.parseInt(st.nextToken());
 
		int[] weight = new int[cnt+1], value = new int[cnt+1];
		int[] maxV = new int[power+1];
 
		for (int i = 1; i <= cnt; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
 
		for (int i = 1; i <= cnt; i++)
			for (int j = power; j >=  weight[i]; j--)
				maxV[j] = Math.max(maxV[j], maxV[j - weight[i]] + value[i]);
		System.out.print(maxV[power]);
	}
}