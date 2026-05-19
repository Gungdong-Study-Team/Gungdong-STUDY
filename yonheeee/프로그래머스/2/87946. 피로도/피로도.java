// 출발 전 꼭 필요한 최소 "최소 필요도", 탐험 후 소모 "소모 필요도"
// dungeons가 세로 던전 개수, 가로 2로 [최소 필요 피로도,  >= 소모 피로도]
// 백트래킹 (갈 수 있는 던전의 쵀대)

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1; // 안되는 경우도 고려
        boolean[] visited = new boolean[dungeons.length];
            
        answer = backtracking(k, dungeons,visited,0);
        return answer;
    }
    
    private int backtracking(int k, int[][] dangeons, boolean[] visited, int count){
      int max = count;
        
        //모든 경우의 수
        for(int i = 0; i < dangeons.length; i++){
            //가지치기
            if(visited[i] || k < dangeons[i][0]) continue;
         
            visited[i] = true;
            int result = backtracking(k- dangeons[i][1],dangeons, visited, count+1);
            max = Math.max(result, max);
            visited[i] = false;
            }    
        return max;
      
      
    }
}