-- select contest_id, round((count(user_id) / select count(user_id) as total from Users) * 100, 2) as percentage from Register group by contest_id;


select contest_id, round(
    ((count(user_id) / (select count(user_id) from Users)) * 100), 2
) as percentage 
from Register group by contest_id
order by percentage desc, contest_id asc;