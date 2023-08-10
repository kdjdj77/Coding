import java.io.*;
import java.util.*;

public class Main{
    static int deque[] = new int[1], s = 0, e = 0, cnt = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(Integer.parseInt(st.nextToken())) {
				case 1:
					if (cnt == deque.length) resize();
			        s = (s-1+deque.length) % deque.length;
			        deque[s] = Integer.parseInt(st.nextToken());
			        cnt++; break;
				case 2:
					if (cnt == deque.length) resize();
			        deque[e] = Integer.parseInt(st.nextToken());
			        e = (e+1) % deque.length;
			        cnt++; break;
				case 3:
					if (cnt == 0) {sb.append(-1).append("\n"); break;}
			        sb.append(deque[s]).append("\n");
			        s = (s+1)%deque.length;
			        cnt--; break;
				case 4:
					if (cnt == 0) {sb.append(-1).append("\n"); break;}
			        e = (e-1+deque.length) % deque.length;
			        sb.append(deque[e]).append("\n");
			        cnt--; break;
				case 5: sb.append(cnt).append("\n"); break;
				case 6: sb.append(cnt == 0 ? 1 : 0).append("\n"); break;
				case 7: sb.append(cnt == 0 ? -1 : deque[s]).append("\n"); break;
				case 8: sb.append(cnt == 0 ? -1 : deque[(e-1+deque.length) % deque.length]).append("\n"); break;
			}
		}
		System.out.print(sb);
	}
    static void resize() {
        int len = deque.length, res[] = new int[len<<1];
        for(int i = 0; i < cnt; i++) res[i] = deque[(s+i) % len];
        deque = res;
        s = 0; e = cnt;
    }
}