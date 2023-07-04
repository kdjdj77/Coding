import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, K, card[], link[];
	public static void main(String[] args) throws IOException {
    	StringBuilder sb = new StringBuilder();
    	st(); N = in(); M = in(); K = in();
    	card = new int[M]; link = new int[M];
        st(); for(int i = 0; i < M; link[i] = i++) card[i] = in();
        Arrays.sort(card);
        st(); while(K-- > 0) {
        	int pos = find(pos(in()));
            if (pos+1 < M) link[pos] = pos+1;
            sb.append(card[pos]).append("\n");
        }
        System.out.print(sb);
    }
	static void st() {try {st = new StringTokenizer(br.readLine());} catch(IOException e) {}}
	static int in() {return Integer.parseInt(st.nextToken());}
    static int find(int n) {return link[n] == n ? n : (link[n] = find(link[n]));}
    static int pos(int n) {
    	int e = M-1;
        for(int s = 0, mid; s < e;) if (card[mid = (e+s-1)/2] > n) e = mid; else s = mid+1;
        return e;
    }
}