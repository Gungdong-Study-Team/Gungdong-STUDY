import java.util.*;

class Solution {

    int sy; int sx;
    int[] dy = {-1, 0, 1 ,0};
    int[] dx = {0, 1, 0, -1};
    
    int r; int c;
    int answer = Integer.MAX_VALUE;
    
    public int solution(String[] board) {
        
        r = board.length; c = board[0].length();
        for(int i=0;i<r;i++){
            for(int j=0;j< c; j++){
                if(board[i].charAt(j) == 'R'){
                    sy = i; sx = j;
                }
            }
        }
        
        dfs(board);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    public void dfs(String[] board){
        Queue<int[]> q = new ArrayDeque();
        
        q.add(new int[]{sy, sx, 0});
        boolean[][] visited = new boolean[r][c];
        visited[sy][sx] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int num = cur[2];
            
            
            if(answer < num) continue;
            if(board[y].charAt(x) == 'G'){
                answer = Math.min(answer, num);
                return;
            }
            
            for(int i=0;i<4;i++){
                int ny = y;
                int nx = x;
                
                while(true){
                    
                    if(ny + dy[i] < 0 || nx + dx[i] < 0 || ny + dy[i] >= r || nx + dx[i] >= c || board[ny+dy[i]].charAt(nx+dx[i]) == 'D'){
                        break;
                    }
                    ny += dy[i];
                    nx += dx[i];
                }

                if(visited[ny][nx]) continue;
                
                
                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx, num+1});
            }
            
        }
        
    }
}