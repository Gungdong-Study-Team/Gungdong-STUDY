// 유니온 파인드 재활
class Solution {
    private int[] parent;
    
    public int find(int x){
        if(parent[x] == x) return x;
        
        return parent[x] = find(parent[x]);
    }
    
    public boolean union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
    
        if(rootA == rootB) return true;
        
        parent[rootA] = rootB;
        return false;
    }
    
    // n은 컴퓨터 개수, coumpters는 2차원 배열로 연결
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && computers[i][j] == 1){
                    union(i,j);
                }
            }
        }
        
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            if(find(i) == i){
                answer++;
            }
        }
        return answer;
    }
}