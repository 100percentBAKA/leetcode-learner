with s as (
    select employee_id, department_id from Employee where primary_flag = 'Y'
)

select 
    e.employee_id, 
    case 
        when s.employee_id is not null then s.department_id 
        else e.department_id
    end as department_id
from 
    Employee e
left join s
    on s.employee_id = e.employee_id
group by
    e.employee_id, department_id
order by
    e.employee_id asc;
