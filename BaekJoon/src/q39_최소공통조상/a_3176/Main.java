package q39_최소공통조상.a_3176;
/*
문제
N개의 도시와 그 도시를 연결하는 N-1개의 도로로 이루어진 도로 네트워크가 있다. 

모든 도시의 쌍에는 그 도시를 연결하는 유일한 경로가 있고, 각 도로의 길이는 입력으로 주어진다.

총 K개의 도시 쌍이 주어진다. 이때, 두 도시를 연결하는 경로 상에서 가장 짧은 도로의 길이와 가장 긴 도로의 길이를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (2 ≤ N ≤ 100,000)

다음 N-1개 줄에는 도로를 나타내는 세 정수 A, B, C가 주어진다. A와 B사이에 길이가 C인 도로가 있다는 뜻이다. 도로의 길이는 1,000,000보다 작거나 같은 양의 정수이다.

다음 줄에는 K가 주어진다. (1 ≤ K ≤ 100,000)

다음 K개 줄에는 서로 다른 두 자연수 D와 E가 주어진다. D와 E를 연결하는 경로에서 가장 짧은 도로의 길이와 가장 긴 도로의 길이를 구해서 출력하면 된다.

출력
총 K개 줄에 D와 E를 연결하는 경로에서 가장 짧은 도로의 길이와 가장 긴 도로의 길이를 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	static class Node {int num, dist; Node(int n, int d) {num = n; dist = d;}}
	static int log2 = 0, depth[], p[][], s[][], l[][];
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Node>[] tree;
	public static void main(String[] args) {
		Reader r = new Reader();
		int N = r.in();
		for(int i = 1; i <= N; i<<=1) log2++;
		p = new int[N+1][log2]; s = new int[N+1][log2];
		l = new int[N+1][log2]; depth = new int[N+1];
		tree = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) tree[i] = new ArrayList<Node>();
		for(int i = 1, a, b, c; i < N; i++) {
			tree[a = r.in()].add(new Node(b = r.in(), c = r.in()));
			tree[b].add(new Node(a, c));
		}
		set(1, 1);
		for(int i = 1; i < log2; i++) for(int j = 1; j <= N; j++) {
			p[j][i] = p[p[j][i-1]][i-1];
			s[j][i] = Math.min(s[j][i-1], s[p[j][i-1]][i-1]);
			l[j][i] = Math.max(l[j][i-1], l[p[j][i-1]][i-1]);
		}
		for(int K = r.in(); K > 0; K--) sb.append(res(r.in(), r.in())).append("\n");
		System.out.print(sb);
	}
	static void set(int node, int cur) {
		depth[node] = cur;
		for(Node next : tree[node]) if (depth[next.num] == 0) {
			set(next.num, cur+1);
			p[next.num][0] = node;
			l[next.num][0] = s[next.num][0] = next.dist;
		}
	}
	static String res(int a, int b) {
		if (depth[a] < depth[b]) {int tmp = a; a = b; b = tmp;}
		int min = Integer.MAX_VALUE, max = -1;
		for(int h = log2-1; h >= 0; h--) if (1<<h <= depth[a] - depth[b]) {
			min = Math.min(min, s[a][h]);
			max = Math.max(max, l[a][h]);
			a = p[a][h];
		}
		if (a == b) return new StringBuilder().append(min).append(" ").append(max).toString();
		for(int h = log2-1; h >= 0; h--) if (p[a][h] != p[b][h]) {
			min = Math.min(min, Math.min(s[a][h], s[b][h]));
			max = Math.max(max, Math.max(l[a][h], l[b][h]));
			a = p[a][h]; b = p[b][h];
		}
		min = Math.min(min, Math.min(s[a][0], s[b][0]));
		max = Math.max(max, Math.max(l[a][0], l[b][0]));
		return new StringBuilder().append(min).append(" ").append(max).toString();
	}
}
class Reader {
	BufferedReader br; StringTokenizer st;
    Reader(){br=new BufferedReader(new InputStreamReader(System.in));}
    String ns(){if(st==null||!st.hasMoreTokens())try{st=new StringTokenizer(br.readLine());}catch(IOException e){}return st.nextToken();}
    int in(){return Integer.parseInt(ns());}
}