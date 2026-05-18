import java.util.*;

class Solution {
    static class Node {
        int r, c, p, time;
        
        Node (int r, int c, int p, int time) {
            this.r = r;
            this.c = c;
            this.p = p;
            this.time = time;
        }
    }
    static int N, M;
    static char[][] map;
    static int startR, startC;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];
        
        for (int i = 0; i < N; i++) {
            String str = maps[i];
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S') {
                    startR = i;
                    startC = j;
                }
            }
        }
        
        answer = bfs();
        return answer;
    }
    
    public int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(startR, startC, 0, 0));
        boolean[][][] visited = new boolean[N][M][2];
        visited[startR][startC][0] = true;
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            
            if (map[now.r][now.c] == 'E' && now.p == 1) {
                return now.time;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                
                if (check(nr, nc) && map[nr][nc] != 'X' && !visited[nr][nc][now.p]) {
                    if (map[nr][nc] == 'L') {
                        q.offer(new Node(nr, nc, 1, now.time + 1));
                        visited[nr][nc][1] = true;
                    } else {
                        q.offer(new Node(nr, nc, now.p, now.time + 1));
                        visited[nr][nc][now.p] = true;
                    }
                }
            }
        }
        
        return -1;
    }
    
    public boolean check(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < M;
    }
}