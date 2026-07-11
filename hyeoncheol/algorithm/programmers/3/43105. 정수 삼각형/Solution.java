class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] memo = new int[triangle.length][];
        
        for (int i = 0; i < memo.length; i++) {
            memo[i] = new int[i + 1];
        }
        
        memo[0][0] = triangle[0][0];
        
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    memo[i][j] = memo[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    memo[i][j] = memo[i - 1][j - 1] + triangle[i][j];
                } else { 
                    int large = Math.max(memo[i - 1][j], memo[i - 1][j - 1]);
                    memo[i][j] = large + triangle[i][j];
                }
            }
        }
        
        int n = memo.length;
        
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, memo[n - 1][i]);
        }
        return answer;
    }
}