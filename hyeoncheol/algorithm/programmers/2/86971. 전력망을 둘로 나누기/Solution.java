import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];
            graph[from].add(to);
            graph[to].add(from);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];
            graph[from].remove(Integer.valueOf(to));
            graph[to].remove(Integer.valueOf(from));
            
            int tmp = bfs(from);
            answer = Math.min(answer, Math.abs(tmp - (n - tmp)));
            
            graph[from].add(to);
            graph[to].add(from);
        }
        
        return answer;
    }
    public int bfs(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];
        q.offer(n);
        visited[n] = true;
        int edge = 0;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            edge++;
            
            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }   
            }
        }
        
        return edge;
    }
}