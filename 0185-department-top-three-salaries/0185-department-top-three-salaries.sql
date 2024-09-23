
-- with s as (
--     select D.name as Department, E.name as Employee, E.salary as sal
--     from Employee E
--     join Department D on D.id = E.departmentId
-- )

-- select
--     D.department as Department,
--     E.name as 

WITH s AS (
    SELECT 
        D.name AS Department,
        E.name AS Employee,
        E.salary AS Salary, 
        DENSE_RANK() OVER (PARTITION BY E.departmentId ORDER BY E.salary DESC) AS rank_no
    FROM 
        Employee E
    JOIN 
        Department D
    ON 
        E.departmentId = D.id
)

SELECT Department, Employee, Salary 
FROM s
WHERE rank_no < 4;

    