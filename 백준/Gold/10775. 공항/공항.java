import java.io.*;

public class Main {
	static int[] root;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine()), P = Integer.parseInt(br.readLine()), res = 0;
		root = new int[G+1];
		for(int i = 1; i <= G; i++) root[i] = i;
		while(P-- > 0) {
			int g = Integer.parseInt(br.readLine()), empty = find(g);
			if (empty == 0) break;
			res++;
			if (empty != empty-1) root[empty] = empty-1;
		}
		System.out.print(res);
	}
	public static int find(int x) {return x == root[x] ? x : (root[x] = find(root[x]));}
}