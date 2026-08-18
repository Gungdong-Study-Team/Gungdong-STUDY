# 특정 형질을 가지는 대장균 찾기

| 항목 | 내용 |
|---|---|
| 사이트 | 프로그래머스 |
| 난이도 | Lv. 1 |
| 날짜 | 2026-08-18 |
| 알고리즘 | SELECT |

## 문제 링크

[SELECT > 특정 형질을 가지는 대장균 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/301646)

## 풀이과정

그냥 & 연산을 할 수 있으면 된다.

## 코드

```sql
SELECT COUNT(*)
FROM ECOLI_DATA
WHERE (GENOTYPE & 5) AND NOT (GENOTYPE & 2);
```

## 회고

& 연산을 어떻게 하는지 몰라서 찾아봤다.  
처음에는 1과 4를 따로 & 한 뒤 or 처리했는데 그냥 5로 한 번에 5를 하는 방법도 있어서 바꿨다.
