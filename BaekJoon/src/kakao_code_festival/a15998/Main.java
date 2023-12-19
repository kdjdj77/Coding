package kakao_code_festival.a15998;

/*
문제
카카오페이는 카카오톡을 통해 송금, 결제 등을 할 수 있는 핀테크 서비스이다. 카카오페이에는 원하는 만큼 현금을 충전하고 사용할 수 있는 카카오머니라는 서비스가 있다. 무지는 오늘부터 현금을 간편하게 사용할 수 있는 카카오머니를 사용해 보기로 하였다. 무지는 좀 더 편리하게 서비스를 이용하기 위해 잔액이 10100 원인 자신의 계좌와 카카오머니 계정을 연결하였다.

처음에 무지의 카카오머니 잔액은 0원이다. 무지가 자신의 통장에서 잔액을 충전하거나 타인에게 송금을 받을 경우 카카오머니 잔액이 증가하며, 이러한 경우를 입금이라고 한다. 또한, 무지가 카카오머니로 결제를 하거나 타인에게 송금을 할 경우 카카오머니 잔액이 감소하며, 이러한 경우를 출금이라고 한다. 이 문제에서는 입금 또는 출금할 때 액수가 1원 단위여야 한다는 것 외의 별다른 제약이 없다고 가정하자. 즉, 실제 카카오머니의 제약사항인 잔액 200만 원 이하, 송금은 1일에 50만 원 한도 등은 무시한다.

x 원이 입금될 경우, 무지의 카카오머니 잔액은 x 원만큼 증가한다. 그러나, x 원을 출금할 때는 상황이 다르다. 만약 잔액이 x 원 이상이라면, 잔액에서 x 원을 차감하면 된다. 그러나, 잔액이 x 원 미만이라면 카카오머니 내부에서 금액을 충당할 수 없기 때문에, 연결된 통장에서 돈을 가져올 필요가 있다. 카카오는 이를 위해 최소 충전 단위 M 을 두어서, 잔액이 x 원 이상이 되기 전까지 M 원을 통장에서 가져오다가, 잔액이 x 원 이상이 되면 x 원을 잔액에서 차감한다. M 은 양의 정수이다.

예를 들어, M = 10,000 이고 무지의 잔액이 1,500원일 때, x = 17,000원을 출금하려는 상황을 가정하여 보자. 무지의 잔액으로는 x = 17,000원을 만들 수 없기 때문에, 카카오머니는 우선 무지의 계좌에서 M = 10,000원을 가져와 잔액을 11,500원으로 만든다. 그러나, 11,500원으로도 x = 17,000원을 만들 수 없기 때문에, 카카오머니는 무지의 계좌에서 또 M = 10,000원을 가져와 잔액을 21,500원으로 만든다. 이제는 17,000원을 출금할 수 있으므로, 잔액에서 x = 17,000원을 차감한다. 최종적으로, 무지의 카카오머니 잔액은 21,500 - 17,000 = 4,500원이 된다.

카카오머니에 남는 입출금 내역과는 별개로, 무지는 카카오머니를 이용하기 시작할 때부터 자신만의 입출금 로그를 작성하였다. 이 로그는 N 개의 두 정수 쌍 (ai, bi)로 이루어져 있으며, 시간 순서대로 저장되어 있다. 무지는 꼼꼼하기 때문에 입금 또는 출금 내역을 로그에서 하나도 빠뜨리지 않았다고 생각한다. 각 쌍의 의미는 아래와 같다.

ai > 0이라면, 무지의 카카오머니에 ai 원이 입금되었다. 입금 결과, 잔액은 bi 원이었다.
ai < 0이라면, 무지의 카카오머니에서 -ai 원이 출금되었다. 출금 결과, 최종적으로 잔액은 bi 원이었다.
ai = 0인 경우는 없다.
위에 언급된 예시의 경우, 무지의 입출금 로그에 (-17,000, 4,500)이 추가되었을 것이다.

그러나 무지는 자신이 제대로 로그를 관리하고 있는지에 대한 걱정이 들기도 해서, 간단하게 로그에 모순이 없는지를 점검해 보고자 한다. 무지가 생각한 방법은, 입출금 로그만 보고 유효한, 즉 로그에 모순이 생기지 않도록 하는 최소 충전 단위 M 이 존재하는지, 존재한다면 값이 얼마인지 확인하는 것이다. 무지를 도와, 이 일을 대신해 줄 프로그램을 작성하라.

입력
첫 번째 줄에 무지의 입출금 로그에 있는 쌍의 수 N(1 ≤ N ≤ 300,000)이 주어진다.

다음 N 개 줄에는 무지가 작성한 입출금 로그가 주어진다. 이 중 i(1 ≤ i ≤ N)번째 줄에는 두 개의 정수 ai 와 bi(-1018 ≤ ai ≤ 1018, ai ≠ 0, 0 ≤ bi ≤ 1018)가 공백 하나를 사이로 두고 주어진다.

출력
만약 유효한 최소 충전 단위 M(1 ≤ M ≤ 9 * 1018)이 존재한다면, 첫 번째 줄에 M 을 출력한다. 가능한 값이 여러 가지 있다면, 그중 9 * 1018 이하인 것을 아무거나 하나 출력한다.

존재하지 않는다면 -1을 출력한다.
 */

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<BigInteger> res = new ArrayList<BigInteger>();
        BigInteger minM = BigInteger.ZERO, before = BigInteger.ZERO;
        while(N-- > 0) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	BigInteger a = new BigInteger(st.nextToken()), b = new BigInteger(st.nextToken());
        	BigInteger diff = b.subtract(before.add(a));
        	before = b;
        	
        	if (a.signum() > 0 || diff.signum() == 0) continue;
        	if (minM.signum() < 0 || minM.compareTo(b) < 0) minM = b;
        	
        	if (res.size() == 0) res = calc(diff, minM);
        	else res.retainAll(calc(diff, minM));
        }
        System.out.print(res.get(0));
    }
    static List<BigInteger> calc(BigInteger diff, BigInteger minM) {
    	List<BigInteger> res = new ArrayList<BigInteger>();
    	for(BigInteger i = BigInteger.ONE;;i = i.add(BigInteger.ONE)) {
    		if (!diff.remainder(i).equals(BigInteger.ZERO)) continue;
    		BigInteger d = diff.divide(i);
    		if (d.compareTo(minM) < 0) return res;
    		res.add(d);
    	}
    }
}