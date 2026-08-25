# 잔챙이 잡은 수 구하기

| 항목 | 내용 |
|---|---|
| 사이트 | 프로그래머스 |
| 난이도 | Lv. 1 |
| 날짜 | 2026-08-25 |
| 알고리즘 | SELECT |

## 문제 링크

[SELECT > 잔챙이 잡은 수 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/293258)

## 풀이과정

LENGTH가 NULL인 것만 세면 된다.

## 코드

```sql
SELECT COUNT(*) AS FISH_COUNT
FROM FISH_INFO
WHERE LENGTH IS NULL;
```

## 회고

EZ
