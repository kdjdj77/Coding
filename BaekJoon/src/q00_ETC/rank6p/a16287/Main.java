package q00_ETC.rank6p.a16287;
/*
문제
국제대학소포센터(ICPC: International Collegiate Parcel Center)는 전세계 대학생들을 대상으로 소포 무료 배송 이벤트를 진행하고 있다. 무료 배송 조건은 보낼 소포가 물품 4개로 구성되어야 하며 이들 물품의 무게 합이 정확히 정해진 정수 무게 w 그램이어야 한다는 것이다.

부산대학교에 있는 찬수는 영국 왕립대학에 있는 수환에게 보낼 물품이 매우 많이 있는데, 각 물품의 무게(모두 정수 그램)는 모두 다르다. 이 이벤트는 한시적으로 진행되는 이벤트이기 때문에 찬수는 자신이 보낼 물품 중에서 이 조건을 만족하는 물품 4개가 있는지 가능하면 빨리 알아내고 싶다. 다시 말해서 서로 다른 n(n ≥ 4)개의 정수로 이루어진 집합 A에서 4개의 원소만 꺼내어 만든 부분집합 B(|B| = 4)가 ∑b∈B b = w 조건을 만족하는지 판단하려고 한다. 

주어진 w와 A에 대해서, 위 조건을 만족하는 부분집합 B가 존재하면 YES를, 아니면 NO를 출력하는 프로그램을 작성하시오.

입력
입력은 표준입력을 사용한다. 입력의 첫 줄에는 무게 w(10 ≤ w ≤ 799,994)와 A의 원소 개수 n(4 ≤ n ≤ 5,000)이 공백으로 분리되어 주어진다. 다음 줄에는 A의 원소인 n개의 정수 ai ∈ A(1 ≤ i ≤ n)가 공백으로 분리되어 주어진다. 각 원소 ai는 1이상 200,000이하이다(1 ≤ ai ≤ 200,000).

출력
출력은 표준출력을 사용한다. 문제의 조건에 따라 YES나 NO를 한 줄에 출력한다.
*/

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		boolean[] S = new boolean[400001];
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				int cur = A[i] + A[j];
				if (cur >= W || W > 400000 + cur) continue;
				if (S[W-cur]) {System.out.print("YES"); return;}
			}
			for(int j = 0; j < i; j++) S[A[i]+A[j]] = true;
		}
		System.out.print("NO");
	}
}