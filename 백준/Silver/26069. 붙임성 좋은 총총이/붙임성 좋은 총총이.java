import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	Set<String> set = new HashSet<>();
    	set.add("ChongChong");
    	while(N-- > 0) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		String a = st.nextToken(), b = st.nextToken();
    		if (set.contains(a) ^ set.contains(b)) set.add(set.contains(a) ? b : a);
    	}
    	System.out.print(set.size());
    }
}