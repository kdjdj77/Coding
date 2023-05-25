import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()), A[] = new int[N], INF = 0;
		for(int i = 0; i < N; i++) INF = Math.max(INF, A[i] = Integer.parseInt(br.readLine()));
		
		boolean[] np = new boolean[INF+1];
		np[0] = np[1] = true;
		for(int i = 2; i <= Math.sqrt(INF); i++)
			if(!np[i]) for(int j = i*i; j < INF+1; j = j+i) np[j] = true;
		for(int num : A) {
			int res = 0;
			for(int a = 2; a <= num/2; a++) if (!np[a] && !np[num-a]) res++;
			sb.append(res).append("\n");
		}
		System.out.print(sb);
	}
}