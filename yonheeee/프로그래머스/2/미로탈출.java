// 출발 -> 레버 -> 문 (레버 안당겨도 문 출구 지나갈 O)
// 시작(S), 출구(E), 레버(L), 통로(O), 벽(X)
// BFS
import java.util.*;

class Solution {
    static class Node{
        int r, c, check,dist;
        
        Node(int r, int c,int check, int dist){
            this.r = r;
            this.c = c;
            this.check = check;
            this.dist = dist;
        }
        
    }
    static int sr,sc,er,ec;
    
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    public int solution(String[] maps) {
        
        sr = -1; sc = -1; er = -1; ec = -1;
        char[][] ground = new char[maps.length][];
        
        for(int i = 0; i < maps.length; i++){
            ground[i] = maps[i].toCharArray();
        }
        
        
        for(int i = 0; i < ground.length; i++){
            
            for(int j = 0; j < ground[i].length; j++){
                if(ground[i][j] == 'S'){
                    sr = i;
                    sc = j;
                }
                if(ground[i][j] == 'E'){
                    er = i;
                    ec = j;
                }
            }
        }
        
        //System.out.println(sr+ " "+sc);
        int answer = bfs(ground);
        return answer;
    }
    
    private int bfs(char[][] ground){
        boolean check = false;
        boolean[][][] visited = new boolean[2][ground.length][ground[0].length];
        Queue<Node> q = new ArrayDeque<>();
        
        q.add(new Node(sr,sc,0,0));
        visited[0][sr][sc] = true;
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(cur.check == 1 && cur.r == er && cur.c == ec) return cur.dist;
            
            for(int d = 0; d < 4; d++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
            
                if(nr >= ground.length || nr < 0 || nc < 0 || nc >= ground[0].length)continue;
                if(ground[nr][nc] == 'X')continue;
                
                int labber = cur.check;
                if(ground[nr][nc] == 'L'){
                    labber = 1;
                }
                
                if(!visited[labber][nr][nc]){
                    q.add(new Node(nr,nc,labber,cur.dist+1));
                    visited[labber][nr][nc] = true;
                }
            }
        }
        return -1;
    }
    
}