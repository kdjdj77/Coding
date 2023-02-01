package q72410;

/*
[문제]
신규 유저가 입력한 아이디를 나타내는 new_id가 매개변수로 주어질 때, "네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디를 return 하도록 solution 함수를 완성해 주세요.

[제한사항]
new_id는 길이 1 이상 1,000 이하인 문자열입니다.
new_id는 알파벳 대문자, 알파벳 소문자, 숫자, 특수문자로 구성되어 있습니다.
new_id에 나타날 수 있는 특수문자는 -_.~!@#$%^&*()=+[{]}:?,<>/ 로 한정됩니다.
*/

class Solution {
    public String solution(String new_id) {
        return lv7(lv6(lv5(lv4(lv3(lv2(lv1(new_id)))))));
    }
    String lv1(String s) {
    	return s.toLowerCase();
    }
	String lv2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.')
                sb.append(c);
        }
        return sb.toString();
	}
	String lv3(String s) {
		s.replace("..", ".");
		while (s.contains("..")) s = s.replace("..", ".");
		return s;
	}
	String lv4(String s) {
		if (s.length() > 0 && s.charAt(0) == '.')
        	s = s.substring(1, s.length());
        if (s.length() > 0 && s.charAt(s.length() - 1) == '.')
        	s = s.substring(0, s.length() - 1);
        return s;
	}
	String lv5(String s) {
		if (s.equals("")) s = "a";
		return s;
	}
	String lv6(String s) {
		if (s.length() < 16) return s;
    	s = s.substring(0, 15);
    	s = lv4(s);
		return s;
    }
	String lv7(String s) {
		StringBuilder sb = new StringBuilder(s);
        if (sb.length() <= 2) {
            char last = sb.charAt(sb.length() - 1);
            while (sb.length() < 3) sb.append(last);
        }
        return sb.toString();
    }
}