-- Write your PostgreSQL query statement below
select
    case when id + 1 > (select max(id) from seat) and mod(id, 2) = 1 then id
    else case mod(id, 2)
        when 0 then id - 1
        when 1 then id + 1
       end
    end as id,
    student
from Seat
order by id