# 잡은 물고기의 평균 길이 구하기

| 항목 | 내용 |
|---|---|
| 사이트 | 프로그래머스 |
| 난이도 | Lv. 1 |
| 날짜 | 2026-08-19 |
| 알고리즘 | IS NULL |

## 문제 링크

[IS NULL > 잡은 물고기의 평균 길이 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/293259)

## 풀이과정

처음에 FORMAT을 쓰는 줄 알고 틀렸는데, ROUND라는 함수가 있다는 것을 알아서 풀었다.

| 함수 | 목적 | 결과 타입 |
|---|---|---|
| `ROUND()` | 계산할 숫자를 반올림 | 숫자 |
| `FORMAT()` | 화면에 보여줄 형식으로 변환 | 문자열 |

## 코드

```sql
SELECT ROUND(AVG(
    CASE
        WHEN LENGTH IS NULL THEN 10
        ELSE LENGTH
    END
), 2) AS AVERAGE_LENGTH
FROM FISH_INFO;
```

## 회고

MySQL 함수 좀 외워야겠다.