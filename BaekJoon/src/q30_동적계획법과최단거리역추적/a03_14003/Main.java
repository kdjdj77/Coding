package q30_동적계획법과최단거리역추적.a03_14003;
/*
문제
수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 
가장 긴 증가하는 부분 수열은 A = {10, 20, 30, 50} 이고, 길이는 4이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (-1,000,000,000 ≤ Ai ≤ 1,000,000,000)

출력
첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.

둘째 줄에는 정답이 될 수 있는 가장 긴 증가하는 부분 수열을 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N], idx = new int[N], path = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		path[0] = A[0];
		idx[0] = 1;
		int max = 1;
		for (int i = 1; i < N; i++) {
			if (path[max - 1] < A[i]) {
				path[max] = A[i];
				idx[i] = ++max;
			} else {
				int index = bs(0, max-1, A[i], path);
				path[index] = A[i];
				idx[i] = index + 1;
			}
		}
		sb.append(max).append("\n");
		
		int find = path[max - 1] + 1;
		int[] res = new int[max];
		for (int i = N-1; i >= 0; i--) {
			if (max < 1) break;
			if (idx[i] == max) { find = A[i]; res[--max] = find; }
		}
		for (int a : res) sb.append(a).append(" ");
		
		System.out.println(sb.toString());
	}
	private static int bs(int l, int r, int num, int[] path) {
		int m;
		while (l < r) {
			m = (l + r) / 2;
			if (path[m] < num) l = m + 1;
			else r = m;
		}
		return r;
	}
}
/*
public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> path = new ArrayList<>();
        int A[] = new int[N+1];
        int idx[] = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());

        path.add(Integer.MIN_VALUE);

        for(int i = 1 ; i <= N; i++){
            int num = A[i];
            int l = 1;
            int r = path.size() - 1;

            if(num > path.get(path.size() - 1)) {
                path.add(num);
                idx[i] = path.size() - 1;
            }
            else {
                while(l < r) {
                    int m = (l + r) / 2;
                    if(path.get(m) >= num) r = m;
                    else l = ++m;
                }
                path.set(r, num);
                idx[i] = r;
            }
        }
        sb.append(path.size() - 1).append("\n");
        
        Stack<Integer> s = new Stack<>();
        int find = path.size() - 1;
        for(int i = N; i > 0; i--) if(idx[i] == find) { s.push(A[i]); find--; }
        
        while (!s.isEmpty()) sb.append(s.pop()).append(" ");
        System.out.print(sb);
    }
}
*/