import java.util.*;

class Solution {
    char[][] arr;
    boolean[][] visited;
    int h, w;
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0 ,0};
    List<Integer> ans;
    public int[] solution(String[] maps) {
        
        h = maps.length;
        w = maps[0].length();
        ans = new ArrayList();
        
        arr = new char[h][w];
        visited = new boolean[h][w];
        
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                arr[i][j] = maps[i].charAt(j);
            }
        }
        
       for(int i=0;i<h;i++){
           for(int j=0;j<w;j++){
               if(!visited[i][j] && arr[i][j] != 'X') bfs(i, j);
           }
       }
        if(ans.size() == 0){
            return new int[]{-1};
        }
        int[] answer = new int[ans.size()];
        for(int i =0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    void bfs(int sy, int sx){
        Queue<int[]> q = new ArrayDeque();
        visited[sy][sx] = true;
        q.offer(new int[]{sy, sx});
        int sum = 0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            sum += arr[y][x] - '0';
            
            for(int dir=0;dir<4;dir++){
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                
                if(ny < 0 || ny >= h || nx < 0|| nx >= w || visited[ny][nx] || arr[ny][nx] == 'X') continue;
                
                
                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx});
            }
        }
        
        if(sum == 0) ans.add(-1);
        else ans.add(sum);
    }
}