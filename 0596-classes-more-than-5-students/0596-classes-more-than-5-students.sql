with s as (
    select class, count(student) as total from Courses group by class
)

select distinct(A.class) 
from Courses A
join s S on S.class = A.class 
where S.total >= 5;