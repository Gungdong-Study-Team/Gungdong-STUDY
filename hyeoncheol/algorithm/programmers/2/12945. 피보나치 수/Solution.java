// 이번주 너무 바빠서 알고리즘 날먹좀 하겠습니다

class Solution {
    public int solution(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % 1234567;
        }
        
        return memo[n];
    }
}