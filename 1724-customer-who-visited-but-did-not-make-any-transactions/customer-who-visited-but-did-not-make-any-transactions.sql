-- Write your PostgreSQL query statement below
with VisitsWithoutTrans as (
    select v.visit_id, v.customer_id from Visits v
    left outer join Transactions t on t.visit_id = v.visit_id
    where t.transaction_id is null
)
select customer_id, count(distinct visit_id) as count_no_trans from VisitsWithoutTrans
group by customer_id