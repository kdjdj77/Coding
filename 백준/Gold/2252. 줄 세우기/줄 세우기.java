import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[N+1];
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		for(int i = 0; i <= N; i++) arr.add(new ArrayList<>());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.get(a).add(b);
			indegree[b]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) if (indegree[i] == 0) q.add(i);
        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int i = 0; i < arr.get(cur).size(); i++) {
                int next = arr.get(cur).get(i);
                indegree[next]--;
                if(indegree[next] == 0) q.add(next);
            }
        }
		System.out.print(sb);
	}
}