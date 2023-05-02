class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int INF = 1000000007;
        int[][] road = new int[m+1][n+1];
        boolean[][] isPuddle = new boolean[m+1][n+1];
        for(int[] p : puddles) isPuddle[p[0]][p[1]] = true;
        
        road[1][1] = 1;
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if (isPuddle[i][j]) continue;
                road[i][j] += (road[i][j-1] + road[i-1][j]) % INF;
            }
        }
        return road[m][n];
    }
}