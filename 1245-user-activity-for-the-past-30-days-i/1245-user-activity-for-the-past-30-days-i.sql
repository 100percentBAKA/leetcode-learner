-- select activity_date as day,
-- count(distinct(
--     case when activity_type != "open_session" and activity_type != "end_session" then user_id end
-- )) as active_users
-- from Activity
-- group by day;

-- select activity_date as day,
-- count(distinct user_id) as active_users 
-- from activity 
-- where activity_type not in ("open_session", "end_session")
-- group by day;

SELECT 
    activity_date AS day,
    COUNT(DISTINCT user_id) AS active_users
FROM 
    activity
WHERE 
    activity_date BETWEEN '2019-06-28' AND '2019-07-27'
GROUP BY 
    activity_date;



