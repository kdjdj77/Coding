import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int nA = Integer.parseInt(st.nextToken());
		int nB = Integer.parseInt(st.nextToken());
		TreeSet<Integer> A = new TreeSet<>();
		Set<Integer> B = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		while(nA-- > 0) A.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		while(nB-- > 0) B.add(Integer.parseInt(st.nextToken()));
		
		A.removeAll(B);
		sb.append(A.size()).append("\n");
		for(int a : A) sb.append(a).append(" ");
		System.out.print(sb);
    }
}