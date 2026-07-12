# 있었는데요 없었습니다

| 항목 | 내용 |
|---|---|
| 사이트 | 프로그래머스 |
| 난이도 | Lv. 3 |
| 날짜 | 2026-07-12 |
| 알고리즘 | JOIN |

## 문제 링크

[JOIN > 있었는데요 없었습니다](https://school.programmers.co.kr/learn/courses/30/lessons/59043)

## 풀이 과정

ON 절 쓰는 법도 모르고, ORDER BY 쓰는 법도 모르고 바보다.  
다 찾아보면서 했다.

## 코드

```sql
SELECT I.ANIMAL_ID, I.NAME
FROM ANIMAL_INS I JOIN ANIMAL_OUTS O
ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.DATETIME > O.DATETIME
ORDER BY I.DATETIME ASC;
```

## 회고

정처기 하면서 진짜 SQL 연습해야겠다.