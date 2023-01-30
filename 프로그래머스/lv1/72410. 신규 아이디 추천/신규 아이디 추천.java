class Solution {
    public String solution(String new_id) {
        return lv7(lv6(lv5(lv4(lv3(lv2(lv1(new_id)))))));
    }
    String lv1(String s) {
    	return s.toLowerCase();
    }
	String lv2(String s) {
		char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : arr)
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.')
                sb.append(c);
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