import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine()), res = 0;
		Set<String> gom = new HashSet<>();
		while(N-- > 0) {
			String s = br.readLine();
			if ("ENTER".equals(s)) gom = new HashSet<>();
			else if (!gom.contains(s)) { gom.add(s); res++; }
		}
		System.out.print(res);
    }
}