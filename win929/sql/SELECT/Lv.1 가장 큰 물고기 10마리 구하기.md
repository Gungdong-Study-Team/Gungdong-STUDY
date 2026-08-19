# 가장 큰 물고기 10마리 구하기

| 항목 | 내용 |
|---|---|
| 사이트 | 프로그래머스 |
| 난이도 | Lv. 1 |
| 날짜 | 2026-08-19 |
| 알고리즘 | SELECT |

## 문제 링크

[SELECT > 가장 큰 물고기 10마리 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/298517)

## 풀이과정

LIMIT, ORDER BY를 적절히 사용하면 된다.

## 코드

```sql
SELECT ID, LENGTH
FROM FISH_INFO
WHERE LENGTH IS NOT NULL
ORDER BY LENGTH DESC, ID ASC
LIMIT 10;
```

## 회고

LIMIT를 몰라서 못 풀었었다.  
외워야지…