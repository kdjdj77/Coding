import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] move = {{1,2,2,2,2},{2,1,3,4,3},{2,3,1,3,4},{2,4,3,1,3},{2,3,4,3,1}};
        int cur = 0, dir[] = new int[5], cmd, INF = 4567890;
        for(int i = 1; i < 5; i++) dir[i] = INF;
        while((cmd = Integer.parseInt(st.nextToken())) != 0) {
            int min = INF, cost = move[cur][cmd];
            for(int i = 0; i < 5; dir[i++]+=cost) min = Math.min(min, dir[i] + move[i][cmd]);
            dir[cur] = min; cur = cmd;
        }
        System.out.print(Arrays.stream(dir).min().orElse(0));
    }
}