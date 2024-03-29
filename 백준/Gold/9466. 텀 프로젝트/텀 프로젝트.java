import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
        	int N = Integer.parseInt(br.readLine()), stu[] = new int[N+1], res = 0;
        	boolean[] visit = new boolean[N+1];
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i = 1; i <= N; i++) stu[i] = Integer.parseInt(st.nextToken());
        	for(int s = 1; s <= N; s++) {
        		if (visit[s]) continue;
        		visit[s] = true;
        		int cur = s;
        		while(!visit[stu[cur]]) visit[cur = stu[cur]] = true;
        		for(int i = s; i != stu[cur]; i = stu[i]) res++;
        	}
        	sb.append(res).append("\n");
        }
        System.out.print(sb);
    }
}