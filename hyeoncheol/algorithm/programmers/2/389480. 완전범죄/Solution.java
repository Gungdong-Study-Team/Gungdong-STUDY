import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] info, int n, int m) {
        solve(0, info, 0, 0, n, m, new boolean[info.length][n + 1][m + 1]);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    public void solve(int idx, int[][] info, int a, int b, int n, int m, boolean[][][] visited) {
        if (idx == info.length) {
            answer = Math.min(answer, a);
            return;
        }
        
        if (a >= answer) return;
        
        if (visited[idx][a][b]) return;
        
        if (b + info[idx][1] < m) {
            visited[idx][a][b + info[idx][1]] = true;
            solve(idx + 1, info, a, b + info[idx][1], n, m, visited);
        }
        
        if (a + info[idx][0] < n) {
            visited[idx][a + info[idx][0]][b] = true;
            solve(idx + 1, info, a + info[idx][0], b, n, m, visited);
        }
    }
}