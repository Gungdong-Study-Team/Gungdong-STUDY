import java.util.*;

class Solution {
    static class Node {
        int r, c, dist;
        
        Node (int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int N, M;
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        int answer = bfs(maps);
        return answer;
    }
    
    static int bfs(int[][] maps) {
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            
            if (now.r == N - 1 && now.c == M - 1) {
                return now.dist;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                
                if (check(nr, nc) && !visited[nr][nc] && maps[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc, now.dist + 1));
                }
            }
        }
        
        return -1;
    }
    
    static boolean check(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < M;
    }
}