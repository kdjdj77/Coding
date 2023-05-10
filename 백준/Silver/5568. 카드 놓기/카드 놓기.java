import java.io.*;
import java.util.*;

public class Main {
	private static int n, k, nums[];
	private static Set<String> set;
	private static boolean[] visit;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		set = new HashSet<>();
		nums = new int[n];
		visit = new boolean[n];
		for(int i = 0; i < n; i++) nums[i] = Integer.parseInt(br.readLine());
		
		find(0, new int[k]);
		System.out.print(set.size());
    }
    private static void find(int depth, int[] tmp) {
    	if (depth == k) {
    		StringBuilder sb = new StringBuilder();
    		for(int a : tmp) sb.append(a);
    		set.add(sb.toString());
    		return;
    	}
    	for(int i = 0; i < n; i++) {
    		if (visit[i]) continue;
    		tmp[depth] = nums[i];
    		visit[i] = true;
    		find(depth+1, tmp);
    		visit[i] = false;
    	}
    }
}