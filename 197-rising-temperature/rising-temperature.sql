-- Write your PostgreSQL query statement below
select a.id from Weather a
inner join Weather b on a.recordDate - b.recordDate = 1
where a.temperature > b.temperature
    