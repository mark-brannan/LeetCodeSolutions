-- Write your PostgreSQL query statement below
with FormerManagers as (
  select distinct m.manager_id from Employees m
  left outer join Employees e on e.employee_id = m.manager_id
  where e.employee_id is null
  and m.manager_id is not null
)
select employee_id from Employees e
inner join FormerManagers fm on fm.manager_id = e.manager_id
where salary < 30000
order by 1
