import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
		int res = 0;
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> in = new ArrayList<>(), out = new ArrayList<>();
		for(int i = 0; i < N; i++) in.add(br.readLine());
		for(int i = 0; i < N; i++) out.add(br.readLine());
		
		while(in.size() > 0) {
			String o1 = in.get(0), o2 = out.get(0);
			if (!o1.equals(o2)) res++;
			in.remove(o2); out.remove(o2);
		}
		System.out.print(res);
    }
}