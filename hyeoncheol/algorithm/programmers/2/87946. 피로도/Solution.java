import java.util.*;

class Solution {
    static int N, answer;
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        answer = 0;
        
        for (int r = N; r > 0; r--) {
            solve(0, new boolean[N], new int[r], r, dungeons, k);
            if (answer > r - 1) break;
        }
        return answer;
    }
    
    public void solve(int idx, boolean[] visited, int[] output, int r, int[][] dungeons, int k) {
        if (idx == r) {
            int tmpK = k;
            int tmp = 0;
            for (int i = 0; i < r; i++) {
               if (tmpK >= dungeons[output[i]][0]) {
                   tmpK -= dungeons[output[i]][1];
                   tmp++;
               } 
            }
            answer = Math.max(answer, tmp);
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[idx] = i;
                solve(idx + 1, visited, output, r, dungeons, k);
                visited[i] = false;
            }
        }
    }
}