import java.util.*;
class Solution {
    static int[] dp;
    public int solution(int N, int number) {
        ArrayList<Set<Integer>> dp = new ArrayList<>();
        for(int i = 0; i < 9; i++) dp.add(new HashSet<>());
        
        int num = N;
        for(int i = 1; i < 9; i++) {
            dp.get(i).add(num);
            num = num * 10 + N;
        }
        
        for(int i = 2; i < 9; i++) {
            for(int j = 1; j < i; j++) {
                int left = j;
                int right = i - j;
                
                for(int n : dp.get(left)) {
                    for(int m : dp.get(right)) {
                        dp.get(i).add(n + m);
                        dp.get(i).add(n - m);
                        dp.get(i).add(n * m);
                        if (m != 0) dp.get(i).add(n / m);
                    }
                }
            }
        }
        for(int i = 1; i < 9; i++)
            if (dp.get(i).contains(number)) return i;
        return -1;
    }
}