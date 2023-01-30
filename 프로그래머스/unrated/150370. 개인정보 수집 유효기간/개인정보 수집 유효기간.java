import java.util.*;

class Solution {
	public static int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();
        String[] arr = today.split("\\.");
        int ty = Integer.parseInt(arr[0]);
        int tm = Integer.parseInt(arr[1]);
        int td = Integer.parseInt(arr[2]);
        int tdd = ty*12*28 + tm*28 + td;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < terms.length; i++) {
        	String[] tmp = terms[i].split(" ");
        	map.put(tmp[0], Integer.parseInt(tmp[1]));
        }
        
        for(int i = 1; i <= privacies.length; i++) {
        	String[] tmp = privacies[i-1].split(" ");
        	
        	String[] date = tmp[0].split("\\.");
        	int y = Integer.parseInt(date[0]);
        	int m = Integer.parseInt(date[1]);
        	int d = Integer.parseInt(date[2]);
        	int dd = y*12*28 + m*28 + d;
        	
        	dd += map.get(tmp[1]) * 28;
        	if (dd <= tdd) list.add(i);
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) res[i] = list.get(i);
        
        return res;
    }
}
