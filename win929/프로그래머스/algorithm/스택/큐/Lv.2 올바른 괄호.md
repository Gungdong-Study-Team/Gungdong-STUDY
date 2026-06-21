# 올바른 괄호

| 항목 | 내용 |
|---|---|
| 사이트 | 프로그래머스 |
| 난이도 | Lv. 2 |
| 날짜 | 2026-06-21 |
| 알고리즘 | 자료 구조, 스택, 문자열 |

## 문제 링크

[스택/큐 > 올바른 괄호](https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=java)

## 풀이 과정

굳이 스택을 쓰지 않고 그냥 카운트만 해도 되는 easy한 문제다.

## 코드

```java
class Solution {
    boolean solution(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else {
                if (cnt == 0) {
                    return false;
                } else {
                    cnt--;
                }
            }
        }

        if (cnt == 0) {
            return true;
        }
        
        return false;
    }
}
```

## 회고

마지막 return 할 때, `return count == 0;`을 할 수도 있었다.  
이런 가오있는 코드 위험하긴 한데, 멋지긴 하네.