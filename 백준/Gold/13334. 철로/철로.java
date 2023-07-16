import java.io.*;
import java.util.*;

class Main {
    static StringTokenizer st = new StringTokenizer("");
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        PriorityQueue<int[]> data = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = in(), a, b;
        while(N-- > 0) data.add((a = in()) < (b = in()) ? new int[] {a, b} : new int[] {b, a});
        int D = in(), cnt = 0, res = 0;
        while(!data.isEmpty()) {
        	int[] dt = data.poll();
            while(!pq.isEmpty() && D < dt[1]-pq.peek()) {pq.poll(); cnt--;}
            if (dt[1]-dt[0] <= D) {pq.add(dt[0]); cnt++;}
            res = Math.max(res, cnt);
        }
        System.out.print(res);
    }
    static int in() throws IOException {
    	if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
    	return Integer.parseInt(st.nextToken());
    }
}