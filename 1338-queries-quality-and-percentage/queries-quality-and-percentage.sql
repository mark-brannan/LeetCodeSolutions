-- Write your PostgreSQL query statement below
with a as (
select
query_name,
1.0 * rating / position rating_position_ratio,
case when rating < 3 then 1 else 0 end as poor_query
from Queries
)
select query_name,
 round(avg(rating_position_ratio), 2) as quality,
 round(100.0 * sum(poor_query)/ count(1), 2) as poor_query_percentage
  From a where query_name is not null
group by query_name