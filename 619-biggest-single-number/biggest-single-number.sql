-- Write your PostgreSQL query statement below
select max(num) as num from (
    select num, count(1) as cnt from MyNumbers
    group by num
    having count(1) = 1
)