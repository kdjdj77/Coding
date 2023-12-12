import java.io.*;
import java.util.*;

public class Main {
    static double[] res = new double[4], rate[] = new double[6][3];
    static int[][] pair = new int[6][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        Map<String, Integer> team = new HashMap<>();
        for(int i = 0; i < 4; i++) team.put(st.nextToken(), i);
        for(int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++) pair[i][j] = team.get(st.nextToken());
            for(int j = 0; j < 3; j++) rate[i][j] = Double.parseDouble(st.nextToken());
        }
        for(int i = 0; i < 3; i++) dfs(0, i, 1, new int[4]);
        for(int i = 0; i < 4; i++) sb.append(res[i]).append("\n");
        System.out.print(sb);
    }
    static void dfs(int p, int x, double percent, int point[]) {
        if (rate[p][x] == 0) return;
        int team1 = pair[p][0], team2 = pair[p][1];
        
        if (x == 0) point[team1] += 3;
        else if (x == 2) point[team2] += 3;
        else {point[team1]++; point[team2]++;}
        percent *= rate[p][x];

        if (p == 5) {
        	ArrayList<Integer> max1 = maxIdxs(point);
    		for(int i : max1) res[i] += max1.size() == 1 ? percent : 2 * percent / max1.size();
        	if (max1.size() > 1) return;
        	
        	for(int i : max1) point[i] = -1;
        	ArrayList<Integer> max2 = maxIdxs(point);
        	for(int i : max2) res[i] += percent / max2.size();
        	return;
        }
        for(int i = 0; i < 3; i++) dfs(p+1, i, percent, point.clone());
    }
    static ArrayList<Integer> maxIdxs(int[] arr) {
    	ArrayList<Integer> res = new ArrayList<>();
        int max = Arrays.stream(arr).max().getAsInt();
    	for(int i = 0; i < 4; i++) if (max == arr[i]) res.add(i);
    	return res;
    }
}