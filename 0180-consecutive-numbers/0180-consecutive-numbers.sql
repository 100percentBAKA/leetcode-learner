with s as (
    select
        num,
        lead(num, 1) over() as num1,
        lead(num, 2) over() as num2
    from Logs
)

select distinct num as ConsecutiveNums from s where num = num1 and num = num2;
