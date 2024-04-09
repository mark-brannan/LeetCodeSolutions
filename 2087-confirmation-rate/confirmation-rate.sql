-- Write your PostgreSQL query statement below
with user_confirmations as (
    select
        Signups.user_id,
        1.0 * count(case when action = 'confirmed' then 1 end) as confirmed_count,
        1.0 * count(1) as all_count
    from Signups left outer join Confirmations
        on Signups.user_id = Confirmations.user_id
    group by Signups.user_id
)
select user_id, round((confirmed_count / all_count), 2) as confirmation_rate from user_confirmations