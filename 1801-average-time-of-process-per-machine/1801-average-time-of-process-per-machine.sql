select machine_id, round(avg(processed_time), 3) as processing_time
from 
(
    select 
    machine_id,
    process_id,
    MAX(case when activity_type="end" then timestamp end)
    -
    MAX(case when activity_type="start" then timestamp end) as processed_time
    from
    Activity
    group by 
    machine_id, process_id
) as sub_query
group by machine_id;