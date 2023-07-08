import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()), wire[][] = new int[N][2];
        int lis[] = new int[N], lisIdx[] = new int[N], preIdx[] = new int[N], len = 0;
        boolean[] visit = new boolean[N];
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(wire, (o1, o2) -> o1[0] - o2[0]);
		for(int i = 0; i < N; i++) {
			int idx = Arrays.binarySearch(lis, 0, len, wire[i][1]);
			lis[idx = idx < 0 ? -(idx+1) : idx] = wire[i][1];
			preIdx[lisIdx[idx] = i] = idx != 0 ? lisIdx[idx-1] : -1;
			if (idx == len) len++;
		}
		sb.append(N-len).append('\n');
		int cur = lisIdx[len-1];
		while(cur != -1) {visit[cur] = true; cur = preIdx[cur];}
		for(int i = 0; i < N; i++) if (!visit[i]) sb.append(wire[i][0]).append('\n');
		System.out.print(sb);
    }
}