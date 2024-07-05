-- Write your PostgreSQL query statement below
with keeps as (
    select email, min(id) min_id from Person group by email
)
delete from Person where id not in (Select min_id from keeps)