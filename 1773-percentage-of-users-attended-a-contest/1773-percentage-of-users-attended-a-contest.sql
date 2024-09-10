-- select contest_id, round((count(user_id) / select count(user_id) as total from Users) * 100, 2) as percentage from Register group by contest_id;


-- select contest_id, round(
--     ((count(user_id) / (select count(user_id) from Users)) * 100), 2
-- ) as percentage 
-- from Register group by contest_id
-- order by percentage desc, contest_id asc;

with s as (
    select count(user_id) as total from Users
)

select r.contest_id, round(
    ((count(r.user_id) / s.total) * 100), 2
) as percentage 
from Register r
cross join s
group by contest_id
order by percentage desc, contest_id asc;