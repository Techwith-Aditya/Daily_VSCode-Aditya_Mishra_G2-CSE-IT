SELECT id, CASE WHEN p_id IS NULL THEN 'Root'
                WHEN p_id IS NOT NULL AND ID IN(SELECT DISTINCT p_id FROM TREE) THEN 'Inner'
                else 'Leaf'
            END AS type

FROM tree
