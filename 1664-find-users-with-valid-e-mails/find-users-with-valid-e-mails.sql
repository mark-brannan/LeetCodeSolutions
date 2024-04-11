-- Write your PostgreSQL query statement below
select user_id, name, mail from Users
where regexp_like(mail, '^[A-Za-z]{1}[A-Za-z0-9_.-]*@leetcode\.com$')