import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

  		PriorityQueue<int[]> gems = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
  		PriorityQueue<Integer> bags = new PriorityQueue<>();
  		while(N-- > 0) gems.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
  		for(int i = 0; i < K; i++) bags.add(Integer.parseInt(br.readLine()));
  		
  		long res = 0;
  		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
  		while(K-- > 0) {
  			int bag = bags.poll();
  			while(!gems.isEmpty() && gems.peek()[0] <= bag) pq.add(gems.poll()[1]);
  			if(!pq.isEmpty()) res += pq.poll();
  		}
  		System.out.println(res);
    }
}