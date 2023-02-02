package q37_문자열알고리즘1.a04_14425;
/*

*/

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<String>();
		while(N-- > 0) set.add(br.readLine());
		
		int res = 0;
		while(M-- > 0) if (set.contains(br.readLine())) res++;
		System.out.print(res);
	}
}