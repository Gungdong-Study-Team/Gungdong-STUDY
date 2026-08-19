# 잡은 물고기 중 가장 큰 물고기의 길이 구하기

| 항목 | 내용 |
|---|---|
| 사이트 | 프로그래머스 |
| 난이도 | Lv. 1 |
| 날짜 | 2026-08-19 |
| 알고리즘 | SUM, MAX, MIN |

## 문제 링크

[SUM, MAX, MIN > 잡은 물고기 중 가장 큰 물고기의 길이 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/298515)

## 풀이과정

CONCAT을 하면 된다.

## 코드

```sql
SELECT CONCAT(MAX(LENGTH), 'cm') AS MAX_LENGTH
FROM FISH_INFO;
```

## 회고

`CONCAT`외워야겠다.

## 관련 알고리즘 정리