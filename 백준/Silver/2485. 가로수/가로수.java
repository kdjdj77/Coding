import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) pq.add(Integer.parseInt(br.readLine()));
        
        int gcd = 0, s = pq.peek();
        for(int i = 0; i < N-1; i++) gcd = gcd(-pq.poll() + pq.peek(), gcd);
        System.out.print((pq.poll() - s) / gcd - N + 1);
    }
    private static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a%b); }
}