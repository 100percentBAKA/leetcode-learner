with s as (
    select row_number() over(order by visited_on) as id, visited_on, sum(amount) as amount
    from Customer
    group by visited_on
),

t as (
    select id, visited_on, amount,
    sum(amount) over(order by visited_on rows between 6 preceding and current row) as cum_sum,
    avg(amount) over(order by visited_on rows between 6 preceding and current row) as cum_avg
    from s
)

select visited_on, cum_sum as amount, round(cum_avg, 2) as average_amount
from t
where id > 6
order by visited_on asc;
