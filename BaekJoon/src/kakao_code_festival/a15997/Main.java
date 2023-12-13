package kakao_code_festival.a15997;

/*
지금 보고 있는 경기는 조별리그가 진행 중인데, 대한민국이 속한 조는 총 4개 국가가 참가하여 경기가 진행되고 있다.

조별리그의 규칙은 다음과 같다.

4개의 팀이 조별리그를 진행한다.
한 팀은 자신을 제외한 모든 상대방과 한 번씩, 총 3번의 경기를 치른다.
경기의 승자는 승점 3점을 받고 비기는 경우 서로 승점 1점을 받는다. 지는 경우에는 승점을 받지 않는다.
조별리그를 모두 치른 후 승점 순으로 순위를 정하는데 승점이 같을 시에는 추첨으로 순위를 정하며, 추첨은 공평하게 진행된다. 순위를 정한 후 상위 2팀은 다음 라운드로 진출한다.
전문가들은 조별 리그의 6경기 전체에 대해서 어떤 팀이 승리할 확률, 비길 확률, 패배할 확률을 예측하였다. 무지와 콘은 모든 경기가 독립적으로 진행되었을 때 (어떠한 경기의 결과가 다른 경기의 결과에 영향을 주지 않음), 전문가들의 예상대로 진행된다면 각 팀이 조별리그를 통과하여 다음 라운드로 진출할 확률이 궁금해졌다. 하지만 무지와 콘은 직접 확률을 계산하지 못했고, 여러분들에게 도움을 요청하였다. 무지와 콘을 도와 이 문제를 해결해보자!

입력
첫 번째 줄에 조별리그를 진행할 국가명 네 개가 공백으로 구분되어 주어진다. 주어지는 모든 국가명은 알파벳 대문자로만 구성된 길이가 1 이상 10 이하인 문자열이다.
두 번째 줄부터 일곱 번째 줄까지는 A B W D L 순으로 주어지는데, 전문가들의 예측에 따르면 A와 B가 경기를 진행했을 때 A가 승리할 확률은 W, 비길 확률은 D, 질 확률은 L이라는 의미이다.
A, B는 각각 첫 번째 줄에 있는 국가명 중 하나이고, A와 B가 같은 경우는 주어지지 않는다. 또한 W, D, L은 최대 소수점 세 자리까지 주어지며, W + D + L = 1이 보장된다.

출력
i 번째 줄에, i 번째로 입력받은 국가가 다음 라운드에 진출할 확률을 출력한다.

출력한 결과와 실제 답을 비교하였을 때의 상대 오차 또는 절대 오차가 10-6 이하인 경우에만 정답으로 인정한다.
 */

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