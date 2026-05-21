class Optimization {
    private int maxDepth = 0; // static 제거, 인스턴스 변수 사용

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        // 탐색 시작 (현재 방문 횟수 0, 현재 피로도 k)
        dfs(0, k, dungeons, visited);
        
        return maxDepth;
    }

    private void dfs(int depth, int k, int[][] dungeons, boolean[] visited) {
        // 던전을 하나 방문할 때마다 최대 방문 횟수 갱신
        maxDepth = Math.max(maxDepth, depth);

        for (int i = 0; i < dungeons.length; i++) {
            // 방문하지 않았고, 현재 피로도로 해당 던전 진입이 가능한 경우만 탐색 (가지치기)
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                
                // 피로도를 소모하고 다음 깊이로 이동
                dfs(depth + 1, k - dungeons[i][1], dungeons, visited);
                
                // 탐색이 끝나면 다른 경로 탐색을 위해 원상복구
                visited[i] = false;
            }
        }
    }
}