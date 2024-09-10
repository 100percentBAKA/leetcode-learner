-- calculate query first 
-- select query_name, round(
--     avg(
--         rating / position
--     ), 2
-- ) as quality, round(
--     (count() / (select count(rating) from Queries))
-- )
-- from Queries 
-- group by query_name;

-- select query_name, round(rating/position, 2) as query from Queries;

-- select count(rating) as check1 from Queries where rating < 3;

select query_name,
round(avg(rating / position), 2) as quality,
round(
    count(case when rating < 3 then 1 end) / count(rating) * 100, 2
) as poor_query_percentage 
from Queries
where query_name is not null
group by query_name;