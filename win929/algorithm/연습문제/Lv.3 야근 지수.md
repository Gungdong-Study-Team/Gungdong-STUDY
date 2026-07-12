# 야근 지수

| 항목 | 내용 |
|---|---|
| 사이트 | 프로그래머스 |
| 난이도 | Lv. 3 |
| 날짜 | 2026-07-12 |
| 알고리즘 | 자료 구조, 우선순위 큐, 그리디 |

## 문제 링크

[연습문제 > 야근 지수](https://school.programmers.co.kr/learn/courses/30/lessons/12927?language=java)

## 풀이 과정

처음에는 for문으로 n번 Arrays.sort() 하다가 시간초과가 나서 pq로 바꿨더니 통과했다.

## 코드

```java
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : works) {
            pq.add(w);
        }
        
        while (n > 0 && !pq.isEmpty()) {
            int p = pq.poll();
            
            if (p > 0) {
                pq.add(p - 1);
            }
            
            n--;
        }
        
        while (!pq.isEmpty()) {
            int w = pq.poll();
            answer += w * w;
        }
        
        return answer;
    }
}
```

## 회고

10^4의 배열을 정렬 10^6 하는 거라 10^10이어서 시간초과가 나는 건데,  그냥 무시하고 풀어서 시간초과가 났다.  
다음에는 계산하면서 풀어야겠다.  
정렬은 nlogn!!!