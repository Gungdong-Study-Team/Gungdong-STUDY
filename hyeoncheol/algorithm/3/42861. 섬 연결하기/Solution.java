import java.util.*;

class Solution {
    static class Edge implements Comparable<Edge> {
        int start, end, cost;
        
        Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    static int[] parent;
    public int solution(int n, int[][] costs) {
        
        parent = new int[n + 1];
        List<Edge> edges = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < costs.length; i++) {
            int start = costs[i][0];
            int end = costs[i][1];
            int cost = costs[i][2];
            
            edges.add(new Edge(start, end, cost));
        }
        
        Collections.sort(edges);
        
        int totalCost = 0;
        int edgeCount = 0;
        
        for (Edge edge : edges) {
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                totalCost += edge.cost;
                edgeCount++;
                
                if (edgeCount == n - 1) {
                    break;
                } 
            }
        }
        
        return totalCost;
    }
    
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}