SELECT flavor
FROM (
    SELECT FLAVOR, TOTAL_ORDER FROM FIRST_HALF
    UNION ALL
    SELECT FLAVOR, TOTAL_ORDER FROM JULY
) AS COMBINED
group by flavor
order by sum(total_order) desc
limit 3
