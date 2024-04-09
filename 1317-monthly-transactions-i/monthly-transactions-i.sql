-- Write your PostgreSQL query statement below
select to_char(trans_date, 'YYYY-MM') as month,
   country,
   count(1) as trans_count,
   count(case when state = 'approved' then 1 end) as approved_count,
   sum(amount) as trans_total_amount,
   sum(case when state = 'approved' then amount else 0 end) as approved_total_Amount
   from Transactions
   group by to_char(trans_date, 'YYYY-MM'), country
