import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
 
        int[] gems[] = new int[N][2], bags = new int[K];
        for (int i = 0; i < N; i++)
        	gems[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < K; i++) bags[i] = Integer.parseInt(br.readLine());
        Arrays.sort(gems, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        Arrays.sort(bags);
        
        long res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0, idx = 0; i < K; i++) {
            while (idx < N && gems[idx][0] <= bags[i]) pq.add(gems[idx++][1]);
            if (!pq.isEmpty()) res += pq.poll();
        }
        System.out.print(res);
    }
}