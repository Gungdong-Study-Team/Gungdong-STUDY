import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            bfs(i, n, computers);
            answer++;
        }
        return answer;
    }
    
    public void bfs(int start, int n, int[][] computers) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.offer(start);
        
        while (!q.isEmpty()) {
            Integer now = q.poll();
            
            for (int i = 0; i < n; i++) {
                if (computers[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}