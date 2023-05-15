import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int res = 0;
		int N = Integer.parseInt(br.readLine());
		Set<String> in = new LinkedHashSet<>(), out = new LinkedHashSet<>();
		for(int i = 0; i < N; i++) in.add(br.readLine());
		for(int i = 0; i < N; i++) out.add(br.readLine());
		
		while(in.size() > 0) {
			ArrayList<String> in2 = new ArrayList<>(in), out2 = new ArrayList<>(out);
			String o1 = in2.get(0), o2 = out2.get(0);
			if (!o1.equals(o2)) res++;
			in.remove(o2); out.remove(o2);
		}
		System.out.print(res);
    }
}