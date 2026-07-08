# 카테고리 별 도서 판매량 집계하기

| 항목 | 내용 |
|---|---|
| 사이트 | 프로그래머스 |
| 난이도 | Lv. 3 |
| 날짜 | 2026-06-23 |
| 알고리즘 | GROUP BY |

## 문제 링크

[GROUP BY > 카테고리 별 도서 판매량 집계하기](https://school.programmers.co.kr/learn/courses/30/lessons/144855)

## 풀이 과정

처음에 문제를 잘못 읽고 `COUNT(*)`을 써서 계속 답이 이상하게 나왔다.  
`WHERE`절에서는 `LIKE`를 안 쓰고 `=`을 쓰는 실수도 했었다.

## 코드

```sql
SELECT CATEGORY, SUM(SALES) AS TOTAL_SALES
FROM BOOK a INNER JOIN BOOK_SALES b
ON a.BOOK_ID = b.BOOK_ID
WHERE SALES_DATE LIKE "2022-01-%"
GROUP BY CATEGORY
ORDER BY CATEGORY;
```

## 회고

SQL 공부 열심히 해야겠다.  
보면 알겠는데 직접 쓰는 건 어렵다.