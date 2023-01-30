package q99_xxx.a99_xxx;
/*

*/

import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
		
		
	}
	public static String solution(String new_id) {
    	String res = new_id;
    	res = lv1(res);
    	System.out.println("- " + res);
    	res = lv2(res);
    	System.out.println("- " + res);
    	res = lv3(res);
    	System.out.println("- " + res);
    	res = lv4(res);
    	System.out.println("- " + res);
    	res = lv5(res);
    	System.out.println("- " + res);
    	res = lv6(res);
    	System.out.println("- " + res);
    	res = lv7(res);
    	System.out.println("- " + res);
    	return res;
    }
	public static String lv1(String s) {
    	return s.toLowerCase();
    }
	public static String lv2(String s) {
    	String tmp = "";
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if (c >= 'a' && c <= 'z') tmp += c;
    		if (c >= '0' && c <= '9') tmp += c;
    		if (c == '-' || c == '_' || c == '.') tmp += c;
    	}
    	return tmp;
    }
	public static String lv3(String s) {
		s = s.replaceAll("..", ".");
    	while(s.contains("..")) {
    		s = s.replace("..", ".");
    	}
    	return s;
    }
	public static String lv4(String s) {
    	if (s.charAt(0) == '.') s = s.substring(1, s.length());
    	if (s.charAt(s.length()-1) == '.') s = s.substring(0, s.length()-1);
    	return s;
    }
	public static String lv5(String s) {
    	if (s.length() == 0) s = "a";
    	return s;
    }
	public static String lv6(String s) {
    	if (s.length() >= 16) s = s.substring(0, 15);
    	s = lv4(s);
    	return s;
    }
	public static String lv7(String s) {
    	while(s.length() < 3) s += s.charAt(s.length()-1);
    	return s;
    }
}