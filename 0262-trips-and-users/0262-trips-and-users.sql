with s as (
    select
    request_at as Day,
    count(*) as total_count,
    count(
        case when status = 'cancelled_by_driver' or status = 'cancelled_by_client' then 1 end
    ) as cancelled_count
from 
    Trips 
where 
    client_id in (select users_id from Users where banned != "Yes") and driver_id in (select users_id from Users where banned != "Yes") and 
    request_at between '2013-10-01' and '2013-10-03'
group by 
    request_at
)

select
    Day,
    round(
        (cancelled_count / total_count),
        2
    ) as "Cancellation Rate"
from 
    s;