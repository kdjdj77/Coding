import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();
        int N = in(br.readLine());
        StringTokenizer st = st(br.readLine()), st2 = st(br.readLine());
        while(N-- > 0) {
            int num = in(st2.nextToken());
            if (in(st.nextToken()) == 0) dq.add(num);
        }
        int M = in(br.readLine()); st = st(br.readLine());
        while(M-- > 0) {
            dq.addFirst(in(st.nextToken()));
            sb.append(dq.pollLast()).append(" ");
        }
        System.out.print(sb);
    }
    static StringTokenizer st(String s) {return new StringTokenizer(s);}
    static int in(String s) {return Integer.parseInt(s);}
}