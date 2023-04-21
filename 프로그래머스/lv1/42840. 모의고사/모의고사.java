import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
    	int len = answers.length;
    	int[] point = new int[3];
    	
    	for(int k = 0; k < 3; k++) {
	        int idx = 0, res[] = new int[len];
	        int[] arr = k == 2 ? new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5} : new int[] {1, 3, 4, 5};
	        
	        for(int i = 0; i < len; i++) {
	        	if (k == 0) res[i] = i % 5 + 1;
	        	else if (k == 1) res[i] = i % 2 == 0 ? 2 : arr[(idx++)%4];
	        	else if (k == 2) res[i] = arr[(idx++)%10];
	        }
	        point[k] = check(res, answers, len);
    	}
        
        return res(point);
    }
    private int check(int[] res, int[] answer, int len) {
    	int r = 0;
    	for(int i = 0; i < len; i++) if (res[i] == answer[i]) r++;
    	return r;
    }
    private int[] res(int[] p) {
    	ArrayList<Integer> re = new ArrayList<>();
    	int max = Math.max(p[0], Math.max(p[1], p[2]));
    	for(int i = 0; i < p.length; i++) if (p[i] == max) re.add(i+1);
    	return re.stream().mapToInt(Integer::intValue).toArray();
    }
}