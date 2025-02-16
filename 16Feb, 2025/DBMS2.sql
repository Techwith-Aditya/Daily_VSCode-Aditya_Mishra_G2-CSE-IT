-- Patients With a Condition

-- Method 1:
-- SELECT patient_id, patient_name, conditions   
-- FROM Patients 
-- WHERE conditions LIKE 'DIAB1%' OR conditions LIKE '% DIAB1%' 

-- Method 2: (REGEXP '^DIAB1' for words starting with DIAB1 && REGEXP '| DIAB1' includes | is a or sign and space means some other words start by DIAB1) 
SELECT patient_id, patient_name, conditions
FROM Patients
WHERE conditions REGEXP '^DIAB1| DIAB1' 
