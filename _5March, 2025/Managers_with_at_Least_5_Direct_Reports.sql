SELECT e.name
FROM Employee AS e 
WHERE e.id IN (
    SELECT managerId
    FROM Employee
    GROUP BY managerId
    HAVING COUNT(*)>=5
);
