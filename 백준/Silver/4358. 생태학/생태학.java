import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
		
		TreeMap<String, Integer> map = new TreeMap<>();
		
		double total = 0;
		String tree = "";
		while((tree = br.readLine()) != null && !tree.isEmpty()) {
			map.put(tree, map.getOrDefault(tree, 0) + 1);
			total++;
		}
		
		for(String s : map.keySet()) {
			sb.append(s).append(" ");
			sb.append(String.format("%.4f", map.get(s)/total*100)).append("\n");
		}
		System.out.print(sb);
    }
}