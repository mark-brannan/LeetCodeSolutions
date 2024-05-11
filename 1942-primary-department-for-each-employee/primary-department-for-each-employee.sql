-- Write your PostgreSQL query statement below
with emp_with_primary as (
    select employee_id, department_id from Employee
    where primary_flag = 'Y'
),
emp_with_dept_count as (
    select
        employee_id, department_id,
        count(department_id) over (partition by employee_id) as dept_count
    from Employee
),
primary_union as (
    select employee_id, department_id from emp_with_primary
    union 
    select employee_id, department_id from emp_with_dept_count
        where dept_count = 1
)
select * from primary_union