package q카카오_04양궁대회;
/*
문제 설명
카카오배 양궁대회가 열렸습니다.
라이언은 저번 카카오배 양궁대회 우승자이고 이번 대회에도 결승전까지 올라왔습니다. 결승전 상대는 어피치입니다.
카카오배 양궁대회 운영위원회는 한 선수의 연속 우승보다는 다양한 선수들이 양궁대회에서 우승하기를 원합니다. 
따라서, 양궁대회 운영위원회는 결승전 규칙을 전 대회 우승자인 라이언에게 불리하게 다음과 같이 정했습니다.

어피치가 화살 n발을 다 쏜 후에 라이언이 화살 n발을 쏩니다.
점수를 계산합니다.
과녁판은 아래 사진처럼 생겼으며 가장 작은 원의 과녁 점수는 10점이고 가장 큰 원의 바깥쪽은 과녁 점수가 0점입니다.
만약, k(k는 1~10사이의 자연수)점을 어피치가 a발을 맞혔고 라이언이 b발을 맞혔을 경우 더 많은 화살을 k점에 맞힌 선수가 k 점을 가져갑니다. 
단, a = b일 경우는 어피치가 k점을 가져갑니다. k점을 여러 발 맞혀도 k점 보다 많은 점수를 가져가는 게 아니고 k점만 가져가는 것을 유의하세요. 
또한 a = b = 0 인 경우, 즉, 라이언과 어피치 모두 k점에 단 하나의 화살도 맞히지 못한 경우는 어느 누구도 k점을 가져가지 않습니다.
예를 들어, 어피치가 10점을 2발 맞혔고 라이언도 10점을 2발 맞혔을 경우 어피치가 10점을 가져갑니다.
다른 예로, 어피치가 10점을 0발 맞혔고 라이언이 10점을 2발 맞혔을 경우 라이언이 10점을 가져갑니다.
모든 과녁 점수에 대하여 각 선수의 최종 점수를 계산합니다.
최종 점수가 더 높은 선수를 우승자로 결정합니다. 단, 최종 점수가 같을 경우 어피치를 우승자로 결정합니다.
현재 상황은 어피치가 화살 n발을 다 쏜 후이고 라이언이 화살을 쏠 차례입니다.
라이언은 어피치를 가장 큰 점수 차이로 이기기 위해서 n발의 화살을 어떤 과녁 점수에 맞혀야 하는지를 구하려고 합니다.

화살의 개수를 담은 자연수 n, 어피치가 맞힌 과녁 점수의 개수를 10점부터 0점까지 순서대로 담은 정수 배열 info가 매개변수로 주어집니다. 
이때, 라이언이 가장 큰 점수 차이로 우승하기 위해 n발의 화살을 어떤 과녁 점수에 맞혀야 하는지를 10점부터 0점까지 순서대로 정수 배열에 담아 
return 하도록 solution 함수를 완성해 주세요. 만약, 라이언이 우승할 수 없는 경우(무조건 지거나 비기는 경우)는 [-1]을 return 해주세요.

제한사항
1 ≤ n ≤ 10
info의 길이 = 11
0 ≤ info의 원소 ≤ n
info의 원소 총합 = n
info의 i번째 원소는 과녁의 10 - i 점을 맞힌 화살 개수입니다. ( i는 0~10 사이의 정수입니다.)
라이언이 우승할 방법이 있는 경우, return 할 정수 배열의 길이는 11입니다.
0 ≤ return할 정수 배열의 원소 ≤ n
return할 정수 배열의 원소 총합 = n (꼭 n발을 다 쏴야 합니다.)
return할 정수 배열의 i번째 원소는 과녁의 10 - i 점을 맞힌 화살 개수입니다. ( i는 0~10 사이의 정수입니다.)
라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우, 가장 낮은 점수를 더 많이 맞힌 경우를 return 해주세요.
가장 낮은 점수를 맞힌 개수가 같을 경우 계속해서 그다음으로 낮은 점수를 더 많이 맞힌 경우를 return 해주세요.
예를 들어, [2,3,1,0,0,0,0,1,3,0,0]과 [2,1,0,2,0,0,0,2,3,0,0]를 비교하면 [2,1,0,2,0,0,0,2,3,0,0]를 return 해야 합니다.
다른 예로, [0,0,2,3,4,1,0,0,0,0,0]과 [9,0,0,0,0,0,0,0,1,0,0]를 비교하면[9,0,0,0,0,0,0,0,1,0,0]를 return 해야 합니다.
라이언이 우승할 방법이 없는 경우, return 할 정수 배열의 길이는 1입니다.
라이언이 어떻게 화살을 쏘든 라이언의 점수가 어피치의 점수보다 낮거나 같으면 [-1]을 return 해야 합니다.
*/

class Solution {
	static int p, res[];
	public static void main(String args[]) {
		int n; int[] info;
		n = 5; info = new int[] {2,1,1,1,0,0,0,0,0,0,0};
		print(solution(n, info));
		n = 1; info = new int[] {1,0,0,0,0,0,0,0,0,0,0};
		print(solution(n, info));
		n = 9; info = new int[] {0,0,1,2,0,1,1,1,1,1,1};
		print(solution(n, info));
		n = 10; info = new int[] {0,0,0,0,0,0,0,0,3,4,3};
		print(solution(n, info));
	}
	public static void print(int[] a) {
    	System.out.print("[" + a[0]);
    	for(int i = 1; i < a.length; i++) System.out.print(", " + a[i]);
    	System.out.println("]");
    }
    public static int[] solution(int n, int[] info) {
    	int[] dp = new int[11];
    	res = new int[11];
    	p = 0;
    	
    	f(info, dp, n, 0);
    	return isNull() ? new int[] {-1} : res;
    }
    public static void f(int[] info, int[] dp, int n, int depth) {
    	if (depth == 10) {
    		dp[depth] += n;
    		int point = isWin(info, dp);
    		if (point >= p) {
    			p = point;
    			for(int i = 0; i < 11; i++) res[i] = dp[i];
    		}
    		dp[depth] -= n;
    		return;
    	}
    	for(int i = n; i >= 0; i--) {
    		dp[depth] += i;
    		f(info, dp, n-i, depth+1);
    		dp[depth] -= i;
    	}
    }
    public static int isWin(int[] apeach, int[] lion) {
    	int A = 0, L = 0;
    	for(int i = 0; i < 11; i++) {
    		if (apeach[i] == 0 && lion[i] == 0) continue;
    		if (apeach[i] >= lion[i]) A += 10-i;
    		else L += 10-i;
    	}
    	return L > A ? L : -1;
    }
    public static boolean isNull() {
    	int cnt = 0;
    	for(int i = 0; i < 11; i++) cnt += res[i];
    	return cnt == 0;
    }
}