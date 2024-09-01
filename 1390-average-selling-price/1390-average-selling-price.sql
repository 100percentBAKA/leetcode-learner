-- select sum(units) as total_units from UnitsSold group by product_id;

select P.product_id, round(coalesce(sum(P.price * U.units) / sum(U.units), 0), 2) as average_price  
from Prices P
left join UnitsSold U on U.product_id = P.product_id and U.purchase_date between P.start_date and P.end_date
group by COALESCE(U.product_id, P.product_id);
