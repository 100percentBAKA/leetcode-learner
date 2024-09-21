-- select * from Employees e
-- join Employees f on e.employee_id = f.reports_to;

select e.employee_id, e.name, count(e.employee_id) as reports_count, round(avg(f.age)) as average_age from Employees e
join Employees f on e.employee_id = f.reports_to
group by e.employee_id, e.name
order by e.employee_id;
