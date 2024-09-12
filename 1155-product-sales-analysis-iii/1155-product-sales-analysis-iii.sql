-- get the min year 
-- join it on the main table

with firstYear as (
    select product_id, min(year) as year from Sales group by product_id
)

select A.product_id, A.year as first_year, A.quantity, A.price 
from Sales A
join firstYear F 
on F.year = A.year and A.product_id = F.product_id;