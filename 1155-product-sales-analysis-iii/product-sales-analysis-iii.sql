-- Write your PostgreSQL query statement below
/*select distinct on (product_id)
    product_id,
    year as first_year,
    quantity,
    price
from Sales
order by product_id, year asc
*/

with FirstYearSales as (
  select product_id, min(year) as year
  from Sales
  group by product_id
)
select
    product_id,
    year as first_year,
    quantity,
    price
from Sales where (product_id, year) in (select * from FirstYearSales)