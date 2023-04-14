class Solution {
    boolean solution(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') res++;
            else if (c == ')') res--;
            
            if (res < 0) return false;
        }
        if (res != 0) return false;
        return true;
    }
}