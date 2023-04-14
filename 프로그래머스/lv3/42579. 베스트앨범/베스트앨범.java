import java.util.*;

class Song implements Comparable<Song>{
	int num;
	int play;
	String genre;
	Song(int n, int p, String g) {
		this.num = n;
		this.play = p;
		this.genre = g;
	}
	@Override
	public int compareTo(Song o) {
		return o.play - this.play;
	}
}
class Solution {
    public int[] solution(String[] genres, int[] plays) {
    	Map<String, ArrayList<Song>> map = new HashMap<>();
    	Map<String, Integer> totalplay = new HashMap<>();
    	for(int i = 0; i < plays.length; i++) {
    		if (!map.containsKey(genres[i])) map.put(genres[i], new ArrayList<>());
    		map.get(genres[i]).add(new Song(i, plays[i], genres[i]));
    		totalplay.put(genres[i], totalplay.getOrDefault(genres[i], 0) + plays[i]);
    	}
    	for(String s : map.keySet()) Collections.sort(map.get(s));
    	
    	ArrayList<String> order = new ArrayList<>(totalplay.keySet());
    	order.sort((o1, o2) -> totalplay.get(o2).compareTo(totalplay.get(o1)));
    	
    	ArrayList<Integer> res = new ArrayList<>();
    	for(String s : order) {
    		int cnt = 2;
    		for(Song n : map.get(s)) {
    			res.add(n.num);
    			cnt--;
    			if (cnt < 1) break;
    		}
    	}
    	return res.stream().mapToInt(i -> i).toArray();
    }
}