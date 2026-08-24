# 동영상 재생기

| 항목 | 내용 |
|---|---|
| 사이트 | 프로그래머스 |
| 난이도 | Lv. 1 |
| 날짜 | 2026-08-24 |
| 알고리즘 | 구현, 시뮬레이션 |

## 문제 링크

[\[PCCP 기출문제\] 1번 / 동영상 재생기](https://school.programmers.co.kr/learn/courses/30/lessons/340213)

## 풀이과정

구현을 잘 하면 되는 문제다.  
귀찮아서 `mm:ss` 형식으로 바꾸는 방법은 구글에 찾아봤다.

## 코드

```java
class Solution {
    int videoLength, opStart, opEnd;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        videoLength = changeLength(video_len);
        int now = changeLength(pos);
        
        opStart = changeLength(op_start);
        opEnd = changeLength(op_end);
        
        if (now >= opStart && now <= opEnd) {
            now = opEnd;
        }
        
        for (String command : commands) {
            now = process(now, command);
        }
        
        return String.format("%02d:%02d", now / 60, now % 60);
    }
    
    int process(int now, String command) {
        if (command.equals("next")) {
            if (now + 10 >= videoLength) {
                now = videoLength;
            } else {
                now += 10;
            }
        } else if (command.equals("prev")) {
            if (now - 10 <= 0) {
                now = 0;
            } else {
                now -= 10;
            }
        }
        
        if (now >= opStart && now <= opEnd) {
            now = opEnd;
        }
        
        return now;
    }
    
    int changeLength(String video_len) {
        String[] str = video_len.split(":");
        int length = 0;
        
        length += Integer.parseInt(str[0]) * 60;
        length += Integer.parseInt(str[1]);
        
        return length;
    }
}
```

## 회고

처음에 now를 전역변수로 만들어 놨더니 이전 실행의 now가 이후 실행에 영향을 줘서 실패했었다.  
프로그래머스는 전역변수를 초기화해주지 않는 것을 기억해야겠다.