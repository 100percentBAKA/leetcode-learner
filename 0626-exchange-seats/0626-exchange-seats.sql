select 
    id, 
    case
        when mod(id, 2) = 0 then lag(student, 1) over(order by id) 
        else coalesce(lead(student, 1) over(order by id) , student)
        end as student
from 
    Seat;

