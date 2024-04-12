-- Write your PostgreSQL query statement below
with TimedActivity as (
    select a.machine_id, b.process_id, (b.timestamp - a.timestamp)::numeric as processing_time
    from Activity a
    inner join Activity b on a.machine_id = b.machine_id
        and a.process_id = b.process_id
        and a.activity_type = 'start' and b.activity_type = 'end'
)
select machine_id, round(avg(processing_time), 3) as processing_time
from TimedActivity
group by machine_id
order by machine_id