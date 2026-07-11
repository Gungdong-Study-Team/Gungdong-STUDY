
import java.util.*;

class Solution {
    class Node {
        int current, count;
        
        Node(int current, int count) {
            this.current = current;
            this.count = count;
        }
    }
    
    public int solution(int x, int y, int n) {
        Queue<Node> q = new ArrayDeque<>();
        int[] visited = new int[y + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[x] = 0;
        q.offer(new Node(x, 0));
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            
            if (now.count > visited[now.current]) {
                continue;
            }
            
            if ((now.current + n <= y) && (now.count + 1 < visited[now.current + n])) {
                visited[now.current + n] = now.count + 1;
                q.offer(new Node(now.current + n, now.count + 1));
            }
            
            if ((now.current * 2 <= y) && (now.count + 1 < visited[now.current * 2])) {
                visited[now.current * 2] = now.count + 1;
                q.offer(new Node(now.current * 2, now.count + 1));
            }
            
            if ((now.current * 3 <= y) && (now.count + 1 < visited[now.current * 3])) {
                visited[now.current * 3] = now.count + 1;
                q.offer(new Node(now.current * 3, now.count + 1));
            }
        }
        
        if (visited[y] == Integer.MAX_VALUE) return -1;
        return visited[y];
    }
}