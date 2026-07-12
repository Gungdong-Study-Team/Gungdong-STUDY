// 연결리스트 and BFS

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        LinkedList<Integer> graph[] = new LinkedList[n+1];

        for(int i = 1; i <= n; i++){
            graph[i] = new LinkedList<>();
        }
        
        for(int i = 0; i < edge.length; i++){
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]); 
        }
        
      
        //System.out.println(Arrays.toString(graph));
        
        Queue<Integer> q = new ArrayDeque<>();
        boolean visited[] = new boolean[n+1];
        //간선 수
        int vertex[] = new int[n+1];
        
        q.add(1);
        visited[1] = true;
             
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next:graph[cur]){
               if(!visited[next]){
                   visited[next] = true;
                vertex[next] = vertex[cur]+1;
                q.add(next);
               }
                
            }
        }
        
        int max = 0;
        //최댓값
        for(int i = 1; i <= n; i++){
            max = Math.max(max, vertex[i]);
        }
        
         int answer = 0;
        for(int i = 1; i <= n; i++){
            if(vertex[i] == max){
                answer++;
            }
        }
        
        return answer;
    }
}