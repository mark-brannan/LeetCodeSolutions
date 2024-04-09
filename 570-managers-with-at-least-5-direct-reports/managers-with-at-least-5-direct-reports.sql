-- Write your PostgreSQL query statement below
with direct_report_counts as (
    select managerId, count(1) as counts from Employee
    where managerId is not null
    group by managerId
)
select e.name from Employee e
inner join direct_report_counts drc on e.id = drc.managerId
where drc.counts >= 5
order by name