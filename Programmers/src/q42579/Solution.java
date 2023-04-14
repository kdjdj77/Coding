package q42579;

/*

*/

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
    	Map<String, ArrayList<Song>> M = new HashMap<>();
    	Map<String, Integer> T = new HashMap<>();
    	for(int i = 0; i < plays.length; i++) {
    		if (!M.containsKey(genres[i])) M.put(genres[i], new ArrayList<>());
    		M.get(genres[i]).add(new Song(i, plays[i], genres[i]));
    		T.put(genres[i], T.getOrDefault(genres[i], 0) + plays[i]);
    	}
    	for(String s : M.keySet()) Collections.sort(M.get(s));
    	
    	ArrayList<String> order = new ArrayList<>(T.keySet());
    	order.sort((o1, o2) -> T.get(o2).compareTo(T.get(o1)));
    	
    	ArrayList<Integer> res = new ArrayList<>();
    	for(String s : order) {
    		int cnt = 2;
    		for(Song n : M.get(s)) {
    			if (cnt-- < 1) break;
    			res.add(n.num);
    		}
    	}
    	return res.stream().mapToInt(i -> i).toArray();
    }
}