package q31_트리.a04_1991;
/*
문제
이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)
한 결과를 출력하는 프로그램을 작성하시오.



예를 들어 위와 같은 이진 트리가 입력되면,

전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
가 된다.

입력
첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 
오른쪽 자식 노드가 주어진다. 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 
자식 노드가 없는 경우에는 .으로 표현한다.

출력
첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.
*/

import java.io.*;
import java.util.*;

class Node{
	char v;
	Node l, r;
	
	Node(char val, Node left, Node right){
		this.v = val;
		this.l = left;
		this.r = right;
	}
}
public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		Node top = new Node('A', null, null);
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			char val = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			create(top, val, left, right);
		}
		front(top); sb.append("\n");
		middle(top); sb.append("\n");
		back(top);
		
		System.out.print(sb);
	}
	public static void create(Node temp, char val, char l, char r) {
		if (temp.v == val) {
			temp.l = l == '.' ? null : new Node(l,null,null);
			temp.r = r == '.' ? null : new Node(r,null,null);
			return;
		}
		if(temp.l != null) create(temp.l, val, l, r);
		if(temp.r != null) create(temp.r, val, l, r);
	}
	private static void front(Node n) {
		if(n == null) return;
		sb.append(n.v);
		front(n.l);
		front(n.r);
	}
	private static void middle(Node n) {
		if(n == null) return;
		middle(n.l);
		sb.append(n.v);
		middle(n.r);
	}
	private static void back(Node n) {
		if(n == null) return;
		back(n.l);
		back(n.r);
		sb.append(n.v);
	}
}