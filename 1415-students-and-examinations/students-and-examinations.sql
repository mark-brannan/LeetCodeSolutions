-- Write your PostgreSQL query statement below
select Students.student_id, Students.student_name, Subjects.subject_name, count(Examinations.subject_name) as attended_exams
from Students
inner join Subjects on 1=1
left outer join Examinations
    on Students.student_id = Examinations.student_id
    and Subjects.subject_name = Examinations.subject_name
    group by Students.student_id, Students.student_name, Subjects.subject_name
    order by student_id, subject_name