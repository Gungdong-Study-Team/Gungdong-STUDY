# 한 해에 잡은 물고기 수 구하기

| 항목 | 내용 |
|---|---|
| 사이트 | 프로그래머스 |
| 난이도 | Lv. 1 |
| 날짜 | 2026-08-19 |
| 알고리즘 | String, Date |

## 문제 링크

[String, Date > 한 해에 잡은 물고기 수 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/298516)

## 풀이과정

COUNT를 하면 됨

## 코드

```sql
SELECT COUNT(*) AS FISH_COUNT
FROM FISH_INFO
WHERE TIME >= '2021-01-01' AND TIME <= '2021-12-31';
```

## 회고

WHERE절에서 처음에는 `TIME ≥ 20210101 AND TIME ≤ 20211231`로 작성했는데 `‘YYYY-MM-DD’` 형식을 사용하는 것을 추천한다.

## 관련 알고리즘 정리