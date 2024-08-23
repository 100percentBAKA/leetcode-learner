-- refrain from using count(*) as it counts it occurence 
-- this would even mark null as 1
-- instead use count(e.subject_name)

select s.student_id, s.student_name, subj.subject_name, count(e.subject_name) as attended_exams 
from Students s
cross join Subjects subj
left join Examinations e on e.student_id = s.student_id 
and subj.subject_name = e.subject_name
group by s.student_id, subj.subject_name
order by s.student_id asc, subj.subject_name asc;

