// 출발(1,1), 상대팀 (5,5)
// 최단 거리 , 도착하지 못하면 -1
// 맵은 5*5가 아닐 수 있음
import java.util.*;

class Solution {    
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
    
    public int solution(int[][] maps) { 
        return bfs(maps);
    }
    
    private static int bfs(int[][] maps){
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<Node> q = new ArrayDeque<>();  
        boolean[][] visited = new boolean[n][m];
        q.add(new Node(0,0,1));
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(cur.r == n-1 && cur.c == m-1){
                return cur.dist;
            }
            
            for(int d = 0; d < 4; d++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                
                if(nr >= n || nr < 0 || nc >= m || nc < 0)continue;
                if(visited[nr][nc] || maps[nr][nc]== 0)continue;
                q.add(new Node(nr,nc,cur.dist+1));
                visited[nr][nc] = true;
            
            }
        }
        return -1;
   
        
        
    }
}