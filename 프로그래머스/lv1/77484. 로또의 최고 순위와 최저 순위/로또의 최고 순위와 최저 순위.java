import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
    	int correct = 0, zeroCnt = 0;
    	
    	int[] rank = new int[] {6, 6, 5, 4, 3, 2, 1};
    	
    	Set<Integer> winSet = new HashSet<>();
    	for(int i : win_nums) winSet.add(i);
    	
    	for(int i = 0; i < lottos.length; i++) {
    		if (winSet.contains(lottos[i])) correct++;
    		else if (lottos[i] == 0) zeroCnt++;
    	}
    	
    	return new int[] {rank[correct + zeroCnt], rank[correct]};
    }
}