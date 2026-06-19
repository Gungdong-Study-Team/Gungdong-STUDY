# 조건별로 분류하여 주문상태 출력하기

| 항목 | 내용 |
|---|---|
| 사이트 | 프로그래머스 |
| 난이도 | Lv. 3 |
| 날짜 | 2026-06-19 |
| 알고리즘 | String, Date |

## 문제 링크

[String, Date > 조건별로 분류하여 주문상태 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/131113)

## 풀이 과정

CASE 문을 작성할 줄 몰라서 공부했다.

## 코드

```sql
SELECT
    ORDER_ID,
    PRODUCT_ID,
    OUT_DATE,
    CASE
        WHEN OUT_DATE <= '2022-05-01' THEN '출고완료'
        WHEN OUT_DATE > '2022-05-01' THEN '출고대기'
        ELSE '출고미정'
    END AS 출고여부
FROM FOOD_ORDER;
```

## 회고

다음에는 CASE 문을 바로 작성하도록 외워둬야겠다.