# Write your MySQL query statement below
select E.name as name, B.bonus as bonus
from Employee E
left join Bonus B on E.empId = B.empId
where B.bonus is null or B.bonus < 1000;