-- Write your PostgreSQL query statement below
with a as (
select d.name as department_name, e.name as employee_name, salary
from Employee e inner join Department d on e.departmentId = d.id
),
ranked_salaries as (
    select *,
       dense_rank() over (order by salary desc) as salary_rank,
       dense_rank() over (partition by department_name order by salary desc) as dept_salary_rank
    from a
)
select department_name as Department,
 employee_name as Employee,
 salary as Salary
 from ranked_salaries
where salary_rank <= 3 or dept_salary_rank <= 3
order by salary desc