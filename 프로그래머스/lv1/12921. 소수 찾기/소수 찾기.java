class Solution {
    public int solution(int n) {
    	final int max = 1000001;
    	boolean[] isNotPrime = new boolean[max];
    	isNotPrime[0] = isNotPrime[1] = true;
    	
    	for(int i = 2; i <= Math.sqrt(n); i++) {
    		for(int j = i*2; j <= n; j += i) {
    			isNotPrime[j] = true;
    		}
    	}
    	
    	int res = 0;
    	for(int i = 0; i <= n; i++) if (!isNotPrime[i]) res++;
        return res;
    }
}