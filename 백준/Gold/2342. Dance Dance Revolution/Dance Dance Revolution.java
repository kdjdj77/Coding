import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cmds = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] move = {{1,2,2,2,2},{2,1,3,4,3},{2,3,1,3,4},{2,4,3,1,3},{2,3,4,3,1}};
        int cur = 0, INF = 4567890, dir[] = new int[5];
        for(int i = 1; i < 5; i++) dir[i] = INF;
        for(int cmd : cmds) {
        	if (cmd == 0) break;
            int min = INF, cost = move[cur][cmd];
            for(int i = 0; i < 5; i++) {
                min = Math.min(min, dir[i]+move[i][cmd]);
                dir[i] += cost;
            }
            dir[cur] = min;
            cur = cmd;
        }
        System.out.print(Arrays.stream(dir).min().orElse(0));
    }
}