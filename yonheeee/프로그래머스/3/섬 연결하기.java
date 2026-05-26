// MST 재활
import java.util.*;

class Solution {
    class Edge implements Comparable<Edge>{
        int from, to, cost;
        
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Solution.Edge o){
            return this.cost - o.cost;
        }
    }
    
    static int[] parent;
    
    static int find(int x){
        if(parent[x] == x) return x;
        
        return parent[x] = find(parent[x]);
    }
    
    static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA == rootB) return true;
        
        parent[rootA] = rootB;
        return false;
        
    }
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < costs.length; i++){
            edges.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }
        
        int answer = 0;
        Collections.sort(edges);
        for(Edge e: edges){
            if(!union(e.from,e.to)){
                answer += e.cost;
            }
        }
        return answer;
    }
}