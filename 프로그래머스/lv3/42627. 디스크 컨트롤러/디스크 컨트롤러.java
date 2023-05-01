import java.util.*;

class Solution {
	public int solution(int[][] jobs) {
		int N = jobs.length;
		int res = 0, time = 0, idx = 0, cnt = 0;

		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		while (cnt < N) {
			while (idx < N && jobs[idx][0] <= time) pq.add(jobs[idx++]);
			if (pq.isEmpty()) {
				time = jobs[idx][0];
				continue;
			}
			
			int[] cur = pq.poll();
			time += cur[1];
			res += time - cur[0];
			cnt++;
		}
		return res / N;
	}
}