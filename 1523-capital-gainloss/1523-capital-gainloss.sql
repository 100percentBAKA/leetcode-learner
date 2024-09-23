with s as (
    select
        stock_name,
        sum(case when operation = 'Buy' then price end) as total_loss,
        sum(case when operation = 'Sell' then price end) as total_profit
    from Stocks
    group by stock_name
)

select stock_name, (total_profit - total_loss) as capital_gain_loss
from s;
