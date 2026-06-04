import java.util.*;

class Solution {
    static class Edge implements Comparable<Edge> {
        int target, weight;
        
        Edge (int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        ArrayList<Integer>[] edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < roads.length; i++) {
            int src = roads[i][0];
            int dest = roads[i][1];
            edges[src].add(dest);
            edges[dest].add(src);
        }
        
        for (int i = 0; i < sources.length; i++) {
            if (sources[i] == destination) {
                answer[i] = 0;
                continue;
            }
            
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[n + 1];
            pq.offer(new Edge(sources[i], 0));
            visited[sources[i]] = true;
            
            while (!pq.isEmpty()) {
                Edge now = pq.poll();
                
                if (now.target == destination) {
                    answer[i] = now.weight;
                    break;
                }
                
                for (Integer next : edges[now.target]) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    pq.offer(new Edge(next, now.weight + 1));
                }
            }
            
            if (answer[i] == 0) {
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}