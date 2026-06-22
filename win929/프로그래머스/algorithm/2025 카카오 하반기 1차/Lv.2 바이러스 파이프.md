# 바이러스 파이프

| 항목 | 내용 |
|---|---|
| 사이트 | 프로그래머스 |
| 난이도 | Lv. 2 |
| 날짜 | 2026-06-22 |
| 알고리즘 | 그래프 이론, 그래프 탐색, 브루트포스, 백트래킹, 너비 우선 탐색 |

## 문제 링크

[2025 카카오 하반기 1차 > 바이러스 파이프](https://school.programmers.co.kr/learn/courses/30/lessons/468373)

## 풀이 과정

딱 보고 그냥 완전 탐색인 것을 알았다.  
그래서 그냥 생각나는 대로 풀었더니 맞았다.

## 코드

```java
import java.util.*;

class Solution {
    static ArrayList<Edge>[] graph;
    static int maxInfection = Integer.MIN_VALUE;
    static int K;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        K = k;
        
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e : edges) {
            graph[e[0]].add(new Edge(e, true));
            graph[e[1]].add(new Edge(e, false));
        }
        
        boolean[] infections = new boolean[n+1];
        infections[infection] = true;
        for (int i = 1; i <= 3; i++) {
            dfs(0, i, infections.clone());   
        }
        
        return maxInfection;
    }
    
    static void dfs(int depth, int openType, boolean[] infections) {
        if (depth == K) {
            int cnt = 0;
            for (boolean b : infections) {
                if (b) {
                    cnt++;
                }
            }
            maxInfection = Math.max(maxInfection, cnt);
            
            return;
        }
        
        boolean[] visited = new boolean[infections.length];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < infections.length; i++) {
            if (infections[i]) {
                visited[i] = true;
                infections[i] = true;
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            for (Edge next : graph[now]) {
                if (!visited[next.node] && next.type == openType) {
                    visited[next.node] = true;
                    infections[next.node] = true;
                    q.add(next.node);
                }
            }
        }
        
        for (int i = 1; i <= 3; i++) {
            dfs(depth + 1, i, infections.clone());
        }
    }
}

class Edge {
    int node;
    int type;
    
    Edge(int[] e, boolean forward) {
        this.node = forward ? e[1] : e[0];
        this.type = e[2];
    }
}
```

## 회고

카카오 코테가 귀찮은 구현이 많은 것 같다.  
아직 쉬운 문제만 풀어서 그런가?