class Solution {
    int solution(int[][] land) {
        int[][] memo = new int[land.length][4];
        
        for (int i = 0; i < 4; i++) {
            memo[0][i] = land[0][i];
        }
        
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    memo[i][j] = Math.max(memo[i][j], land[i][j] + memo[i - 1][k]);
                }
            }
        }
        
        int answer = -1;
        for (int i = 0; i < 4; i++) {
            if (answer < memo[land.length - 1][i]) {
                answer = memo[land.length - 1][i];
            }
        }
        
        return answer;
    }
}