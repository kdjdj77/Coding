import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> A = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        String str = br.readLine();
        while (str != null && str != "") {
        	A.add(Integer.parseInt(str));
        	str = br.readLine();
        }
        calc(0, A.size()-1);
        System.out.print(sb);
    }

    static void calc(int s, int e) {
        if (s > e) return;

        int m = s+1;
        while (m <= e && A.get(m) < A.get(s)) m++;

        calc(s+1, m-1);
        calc(m, e);
        sb.append(A.get(s)).append("\n");
    }
}