import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Queue<Integer>> res = new ArrayList<>();
	static ArrayList<Integer>[] map = new ArrayList[10001];
	static int num = 0, cnt = 0, find[] = new int[10001];
	static boolean[] visit = new boolean[10001];
	static Stack<Integer> s = new Stack<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int V = Integer.parseInt(st.nextToken())+1, E = Integer.parseInt(st.nextToken());
		for(int i = 1; i < V; i++) map[i] = new ArrayList<>();
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		for(int i = 1; i < V; i++) if (find[i] == 0) scc(i);
		res.sort((o1, o2) -> o1.peek() - o2.peek());
		sb.append(cnt).append("\n");
		for(Queue<Integer> q : res) {
			while(!q.isEmpty())	sb.append(q.poll()).append(" ");
			sb.append("-1\n");
		}
		System.out.print(sb); 
	}
	static int scc(int cur) {
		s.add(cur);
		int ret = find[cur] = ++num, tmp = 0;
		for(int next : map[cur]) {
			if (find[next] == 0) ret = Math.min(ret, scc(next));
			else if (!visit[next]) ret = Math.min(ret, find[next]);
		} 
		if (find[cur] == ret) {
			Queue<Integer> pq = new PriorityQueue<>();
			while(tmp != cur) visit[tmp = s.pop()] = pq.add(tmp);
			res.add(pq);
			cnt++;
		}
		return ret;
	}
}