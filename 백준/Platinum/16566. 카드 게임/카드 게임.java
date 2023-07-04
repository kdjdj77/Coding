import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
    	int res = st(0), N = in(), M = in(), K = in(), sort[] = new int[M], pos[] = new int[M];
    	boolean[] have = new boolean[N+1];
        for(int i = st(0); i < M; pos[i] = i++) have[in()] = true;
        for(int i = st(1), idx = 0; i <= N; i++) if (have[i]) sort[idx++] = i;
        StringBuilder sb = new StringBuilder();
        while(K-- > 0) {
        	int n = in()+1, l = 0, r = M-1, mid;
        	while(l <= r) if (n <= sort[mid=(l+r)/2]) r = (res=mid)-1; else l = mid+1;
            if ((res = find(res, pos)) < M-1) pos[res] = res + 1;
        	sb.append(sort[res]).append("\n");
        }
        System.out.println(sb);
    }
    static int st(int n) {try {st = new StringTokenizer(br.readLine());} catch(IOException e) {} return n;}
    static int in() {return Integer.parseInt(st.nextToken());}
    static int find(int n, int[] pos) {return pos[n] == n ? n : (pos[n] = find(pos[n], pos));}
}