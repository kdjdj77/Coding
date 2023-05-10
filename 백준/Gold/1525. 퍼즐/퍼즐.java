import java.io.*;
import java.util.*;

public class Main {
    private static class Board{
        int num, idx0, cnt;
        public Board(int n, int idx0, int cnt) {
            this.num = n;
            this.idx0 = idx0;
            this.cnt = cnt;
        }
    }
    private static final int[] p10 = {1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int init = 0, pos0 = -1;
        for (int i = 0; i < 9; i++) {
            if (i%3 == 0) st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            init += num * p10[8-i];
            if (num == 0) pos0 = 8-i;
        }

        Queue<Board> q = new LinkedList<>();
        HashMap<Integer, Board> visit = new HashMap<>();
        Board first = new Board(init, pos0,0);
        q.add(first); visit.put(init, first);

        ArrayList<ArrayList<Integer>> move = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
        	ArrayList<Integer> next = new ArrayList<>();
        	if (i/3 != 0) next.add(i-3);
        	if (i%3 != 0) next.add(i-1);
        	if ((i+1)%3 != 0) next.add(i+1);
        	if (i/3 != 2) next.add(i+3);
        	move.add(next);
        }
        
        int res = -1;
        while (!q.isEmpty()){
            Board cur = q.poll();
            if (cur.num == 123456780) { res = cur.cnt; break; }
            
            int s = cur.idx0;
            ArrayList<Integer> arr = move.get(s);
            for(int e : arr) {
            	int next = swap(s, e, cur.num);
            	Board tmp = new Board(next, e, cur.cnt+1);
                
                if (visit.containsKey(next)) continue;
                visit.put(next, tmp);
                q.add(tmp);
            }
        }
        System.out.print(res);
    }
    public static int d(int num, int idx) { return num / p10[idx] % 10; }
    private static int swap(int s, int e, int num) {
        return num - d(num,s)*p10[s] - d(num,e)*p10[e] + d(num,s)*p10[e] + d(num,e)*p10[s];
    }
}