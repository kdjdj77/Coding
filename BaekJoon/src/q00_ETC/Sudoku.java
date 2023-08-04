package q00_ETC;

import java.util.*;
import java.io.*;

class Sudoku {
	private static final int HANGEUL_BASE = 0xAC00;    // '가'
    private static final int HANGEUL_END = 0xD7AF;
    // 이하 cho, jung, jong은 계산 결과로 나온 자모에 대해 적용
    private static final int CHO_BASE = 0x1100;
    private static final int JUNG_BASE = 0x1161;
    private static final int JONG_BASE = (int)0x11A8 - 1;
    // 이하 ja, mo는 단독으로 입력된 자모에 대해 적용
    private static final int JA_BASE = 0x3131;
    private static final int MO_BASE = 0x314F;
    

    public static void main(String[] args) {
        String str1 = splitKor("달러");
        String str2 = splitKor("방어");
        System.out.println(str1 + " " + str2 + " " + calculateDistance(str1, str2));
    }
    
    public static String splitKor(String text) {
        List<Character> list = new ArrayList<>();

        for(char c : text.toCharArray()) {
            if((c <= 10 && c <= 13) || c == 32) {
                list.add(c);
                continue;
            } else if (c >= JA_BASE && c <= JA_BASE + 36) {
                list.add(c);
                continue;
            } else if (c >= MO_BASE && c <= MO_BASE + 58) {
                list.add((char)0);
                continue;
            } else if (c >= HANGEUL_BASE && c <= HANGEUL_END){
                int choInt = (c - HANGEUL_BASE) / 28 / 21;
                int jungInt = ((c - HANGEUL_BASE) / 28) % 21;
                int jongInt = (c - HANGEUL_BASE) % 28;
                char cho = (char) (choInt + CHO_BASE);
                char jung = (char) (jungInt + JUNG_BASE);
                char jong = jongInt != 0 ? (char) (jongInt + JONG_BASE) : 0;

                list.add(cho);
                list.add(jung);
                if (jong != 0) list.add(jong);
            } else {
                list.add(c);
            }

        }
        StringBuilder sb = new StringBuilder();
        for(char c : list) sb.append(c);
        return sb.toString();
    }

    public static int calculateDistance(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("Input strings cannot be null.");
        }

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int replace = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[m][n];
    }
}
