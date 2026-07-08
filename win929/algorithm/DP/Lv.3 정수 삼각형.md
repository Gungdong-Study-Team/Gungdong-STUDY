# 정수 삼각형

| 항목 | 내용 |
|---|---|
| 사이트 | 프로그래머스 |
| 난이도 | Lv. 3 |
| 날짜 | 2026-07-08 |
| 알고리즘 | DP |

## 문제 링크

[동적계획법(Dynamic Programming) > 정수 삼각형](https://school.programmers.co.kr/learn/courses/30/lessons/43105)

## 풀이 과정

처음에는 그냥 dfs로 풀려고 하니 시간초과가 났다.  
그래서 dp로 풀었다.  
처음엔 dp배열을 만들어서 풀었는데, 다 풀고 나니 바텀업이라 필요 없는 것 같아서 지웠다.

## 코드

```java
class Solution {
    public int solution(int[][] triangle) {
        for (int i = triangle.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                triangle[i-1][j] = triangle[i-1][j] + Math.max(triangle[i][j], triangle[i][j+1]);
            }
        }
        
        return triangle[0][0];
    }
}
```

## 회고

오랜만에 푸니 생각보다 꽤 오래 걸렸다.  
꾸준히 풀어서 빠르게 풀도록 노력하자.