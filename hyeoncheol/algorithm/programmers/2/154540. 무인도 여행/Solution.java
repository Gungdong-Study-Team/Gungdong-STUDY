import java.util.*;

class Node {
    int r, c;
    
    Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static boolean[][] visited;

    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        visited = new boolean[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    visited[i][j] = true;
                    list.add(bfs(i, j, maps));
                }
            }
        }
        
        if (list.isEmpty()) {
            return new int[] {-1};
        }
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }

    
    public int bfs(int r, int c, String[] maps) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(r, c));
        int food = 0;
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            
            food += maps[now.r].charAt(now.c) - '0';
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if (check(nr, nc, maps) && !visited[nr][nc] && maps[nr].charAt(nc) != 'X') {
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc));
                }
            }
        }
        
        return food;
    }
    
    public boolean check(int nr, int nc, String[] maps) {
        return nr >= 0 && nr < maps.length && nc >= 0 && nc < maps[0].length();
    }
}