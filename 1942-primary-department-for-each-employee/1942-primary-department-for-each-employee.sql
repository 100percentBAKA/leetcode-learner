WITH s AS (
    SELECT employee_id, department_id 
    FROM Employee 
    WHERE primary_flag = 'Y'
)

SELECT 
    e.employee_id,
    CASE
        WHEN s.employee_id IS NOT NULL THEN s.department_id
        ELSE e.department_id
    END AS department_id
FROM Employee e
LEFT JOIN s ON e.employee_id = s.employee_id
group by e.employee_id, department_id
order by e.employee_id asc;
