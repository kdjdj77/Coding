package q31_트리.a02_11725;
/*
문제
트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 트리의 지름을 구하는 프로그램을 작성하시오.

입력
트리가 입력으로 주어진다. 먼저 첫 번째 줄에서는 트리의 정점의 개수 V가 주어지고 (2 ≤ V ≤ 100,000)둘째 줄부터 V개의 줄에 걸쳐 간선의 정보가 다음과 같이 주어진다. 정점 번호는 1부터 V까지 매겨져 있다.

먼저 정점 번호가 주어지고, 이어서 연결된 간선의 정보를 의미하는 정수가 두 개씩 주어지는데, 하나는 정점번호, 다른 하나는 그 정점까지의 거리이다. 예를 들어 네 번째 줄의 경우 정점 3은 정점 1과 거리가 2인 간선으로 연결되어 있고, 정점 4와는 거리가 3인 간선으로 연결되어 있는 것을 보여준다. 각 줄의 마지막에는 -1이 입력으로 주어진다. 주어지는 거리는 모두 10,000 이하의 자연수이다.

출력
첫째 줄에 트리의 지름을 출력한다.
*/

import java.io.*;
import java.util.*;

class Node {
	int next, w;
	public Node(int n, int w) {
		this.next = n;
		this.w = w;
	}
}
public class Main {
	static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
	static boolean[] visit;
	static int max = 0, edge;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		
		for(int i = 0; i <= N; i++) tree.add(new ArrayList<>());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			while(true) {
				int e = Integer.parseInt(st.nextToken());
				if (e == -1) break;
				int w = Integer.parseInt(st.nextToken());
				tree.get(s).add(new Node(e, w));
			}
		}
		dfs(1, 0);
		visit = new boolean[N+1];
		dfs(edge, 0);
		System.out.print(max);
	}
	public static void dfs(int x, int len) {
        if(len > max) { max = len; edge = x; }
        visit[x] = true;
        
        for(Node n : tree.get(x)) {
            if(!visit[n.next]) {
                dfs(n.next, n.w + len);
                visit[n.next] = true;
            }
        }
    }
}