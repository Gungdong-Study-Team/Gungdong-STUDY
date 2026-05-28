import java.util.*;

class Solution {
    static int N = 5;
    static char[][] places;
    
    static class Node{
        int r, c, dist;
        Node(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    public int[] solution(String[][] input) {
        int[] answer = new int[5];
        
        for(int k = 0; k < 5; k++) {
            places = new char[N][N];
            
            for(int i = 0; i < N; i++) {
                String line = input[k][i];
                for(int j = 0; j < N; j++) {
                    places[i][j] = line.charAt(j);
                }
            }
            
            answer[k] = 1; // 일단 성공으로 시작
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(places[i][j] == 'P') {
                        if(!Check(i,j)) {
                            answer[k] = 0;
                            break;
                        }
                    }
                }
                if(answer[k] == 0) break;
            }
        }
        
        return answer;
    }

    private static boolean Check(int hx, int hy) {
        boolean[][] visited = new boolean[N][N];
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(hx,hy,0));
        visited[hx][hy] = true;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            if(cur.dist >= 2) continue;
            
            for(int d = 0; d < 4; d++) {
                int sr = cur.r + dr[d];
                int sc = cur.c + dc[d];
                
                if(sr >= N || sr < 0 || sc >= N || sc < 0) continue;
                if(visited[sr][sc] || places[sr][sc] == 'X') continue;
                
                if(places[sr][sc] == 'P') return false;
                visited[sr][sc] = true;
                
                if(places[sr][sc] == 'O') {
                    q.add(new Node(sr, sc, cur.dist + 1));
                }
            }
        }
        
        return true;
    }
}