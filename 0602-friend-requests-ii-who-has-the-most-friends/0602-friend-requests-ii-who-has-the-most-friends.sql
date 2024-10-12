-- no of times an id if appearing in column 1 + column 2

-- with s as (
--     select requester_id, count(*) as req_count
--     from RequestAccepted
--     group by requester_id
-- ),

-- t as (
--     select accepter_id, count(*) as acc_count
--     from RequestAccepted
--     group by accepter_id
-- ),

-- u as (
--     select s.requester_id as id, s.req_count, t.acc_count
--     from s
--     left join t on s.requester_id = t.accepter_id

--     union all 

--     select s.requester_id as id, s.req_count, t.acc_count
--     from s
--     right join t on s.requester_id = t.accepter_id
-- )

-- select * from s;

-- select * from u;

-- select id, (req_count + acc_count) as num
-- from u
-- order by num desc;

-- select 
--     distinct requester_id as id,
--     (select count(*) from RequestAccepted group by requester_id) + (select count(*) from RequestAccepted group by accepter_id)
-- from 
--     RequestAccepted;


-- select requester_id, count(*) from RequestAccepted group by requester_id;

with s as (
    select requester_id, count(*) as req_count
    from RequestAccepted
    group by requester_id
),

t as (
    select accepter_id, count(*) as acc_count
    from RequestAccepted
    group by accepter_id
),

u as (
    select s.requester_id as id, s.req_count, coalesce(t.acc_count, 0) as acc_count
    from s
    left join t on s.requester_id = t.accepter_id

    union

    select t.accepter_id as id, coalesce(s.req_count, 0) as req_count, t.acc_count
    from t
    left join s on s.requester_id = t.accepter_id
)

select id, 
    (req_count + acc_count) as num
from
    u
order by
    num desc
limit 1;