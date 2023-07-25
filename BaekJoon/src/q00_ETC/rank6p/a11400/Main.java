package q00_ETC.rank6p.a11400;
/*
문제
그래프가 주어졌을 때, 단절선을 모두 구해 출력하는 프로그램을 작성하시오.

단절선이란 그 간선을 제거했을 때, 그래프가 두 개 또는 그 이상으로 나누어지는 간선을 말한다. 즉, 제거했을 때 그래프의 connected component의 개수가 증가하는 간선을 말한다.

입력
첫째 줄에 두 정수 V(1≤V≤100,000), E(1≤E≤1,000,000)가 주어진다. 이는 그래프가 V개의 정점과 E개의 간선으로 이루어져 있다는 의미이다. 다음 E개의 줄에는 간선에 대한 정보를 나타내는 두 정수 A, B가 주어진다. 이는 A번 정점과 B번 정점이 연결되어 있다는 의미이며, 방향은 양방향이다.

그래프는 항상 연결되어 있으며, 같은 간선이 두 번 이상 들어오는 경우는 없다. 또, A와 B가 같은 경우도 없다.

그래프의 정점은 1부터 V까지 자연수이다.

출력
첫째 줄에 단절선의 개수 K를 출력한다.

둘째 줄부터 K개 줄에는 단절선을 사전순으로 한 줄에 하나씩 출력한다. 간선은 "A B" 형식으로 출력해야 하고, A < B를 만족해야 한다. 같은 간선은 한 번만 출력하면 된다. 즉, "A B"를 출력한 경우에 "B A"는 출력할 필요가 없다.
*/

import java.io.*;
import java.util.*;

public class Main {
	static int V, E, N[], cnt = 0;
	static ArrayList<Integer>[] link;
	static ArrayList<int[]> res = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
    	st(); link = new ArrayList[(V = in()+1)]; N = new int[V]; E = in();
        for(int i = 1; i < V; i++) link[i] = new ArrayList<>();
        for(int i = 0, a, b; i < E; i++) {st(); link[a=in()].add(b=in()); link[b].add(a);}
        dfs(1, 0);
        Collections.sort(res, (a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        StringBuilder sb = new StringBuilder().append(res.size()).append("\n");
        for(int[] r : res) sb.append(r[0]).append(" ").append(r[1]).append("\n");
        System.out.print(sb);
    }
    static int in() {return Integer.parseInt(st.nextToken());}
    static void st() throws IOException {st = new StringTokenizer(br.readLine());}
    static int[] arr(int a, int b) {return a < b ? new int[] {a, b} : new int[] {b, a};}
    static int dfs(int cur, int before) {
    	int min = N[cur] = ++cnt, min2;
    	for(int next : link[cur]) {
    		if (next == before) continue;
    		if (N[next] != 0) min2 = N[next];
    		else if ((min2 = dfs(next, cur)) > N[cur]) res.add(arr(cur, next));
            min = Math.min(min, min2);
        }
    	return min;
    }
}