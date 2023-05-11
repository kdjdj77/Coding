package q00_ETC.a1525;
/*
문제
3×3 표에 다음과 같이 수가 채워져 있다. 오른쪽 아래 가장 끝 칸은 비어 있는 칸이다.

1	2	3
4	5	6
7	8	 
어떤 수와 인접해 있는 네 개의 칸 중에 하나가 비어 있으면, 수를 그 칸으로 이동시킬 수가 있다. 물론 표 바깥으로 나가는 경우는 불가능하다. 우리의 목표는 초기 상태가 주어졌을 때, 최소의 이동으로 위와 같은 정리된 상태를 만드는 것이다. 다음의 예를 보자.

1	 	3
4	2	5
7	8	6

1	2	3
4	 	5
7	8	6

1	2	3
4	5	 
7	8	6

1	2	3
4	5	6
7	8	 
가장 윗 상태에서 세 번의 이동을 통해 정리된 상태를 만들 수 있다. 이와 같이 최소 이동 횟수를 구하는 프로그램을 작성하시오.

입력
세 줄에 걸쳐서 표에 채워져 있는 아홉 개의 수가 주어진다. 한 줄에 세 개의 수가 주어지며, 빈 칸은 0으로 나타낸다.

출력
첫째 줄에 최소의 이동 횟수를 출력한다. 이동이 불가능한 경우 -1을 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
    private static final int[] p10 = {1,10,100,1000,10000,100000,1000000,10000000,100000000};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int init = 0, pos0 = -1;
        for (int i = 0; i < 9; i++) {
            if (i%3 == 0) st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            init += n * p10[8-i];
            if (n == 0) pos0 = 8-i;
        }

        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, int[]> visit = new HashMap<>();
        q.add(init);
        visit.put(init, new int[] {pos0, 0});

        ArrayList<ArrayList<Integer>> move = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
        	ArrayList<Integer> to = new ArrayList<>();
        	if (i/3 != 0) to.add(i-3);
        	if (i%3 != 0) to.add(i-1);
        	if ((i+1)%3 != 0) to.add(i+1);
        	if (i/3 != 2) to.add(i+3);
        	move.add(to);
        }
        int res = -1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if (cur == 123456780) { res = visit.get(cur)[1]; break; }
            
            int[] b = visit.get(cur);
            ArrayList<Integer> arr = move.get(b[0]);
            for(int to : arr) {
            	int next = swap(b[0], to, cur);
                
                if (visit.containsKey(next)) continue;
                visit.put(next, new int[] {to, b[1]+1});
                q.add(next);
            }
        }
        System.out.print(res);
    }
    private static int gd(int n, int p) { return n / p10[p] % 10; }
    private static int swap(int s, int e, int n) {
        return n - gd(n,s)*p10[s] - gd(n,e)*p10[e] + gd(n,s)*p10[e] + gd(n,e)*p10[s];
    }
}