# 네트워크

| 항목 | 내용 |
|---|---|
| 사이트 | 프로그래머스 |
| 난이도 | Lv. 3 |
| 날짜 | 2026-06-21 |
| 알고리즘 | 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색 |

## 문제 링크

[DFS/BFS > 네트워크](https://school.programmers.co.kr/learn/courses/30/lessons/43162)

## 풀이 과정

그냥 BFS를 쓰면 되는 문제다.

## 코드

```java
import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        
        int cnt = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                q.add(i);
                visited[i] = true;   
                
                cnt++;
            }
            
            while (!q.isEmpty()) {
                int now = q.poll();
                
                for (int j = 0; j < n; j++) {
                    if (computers[now][j] == 1 && !visited[j]) {
                        q.add(j);
                        visited[j] = true;
                    }
                }
            }
        }
        
        return cnt;
    }
}
```

## 회고

이지하다.