SELECT DISTINCT CITY FROM STATION
WHERE SUBSTRING(CITY, LEN(CITY), 1) = 'a'
OR
SUBSTRING(CITY, LEN(CITY), 1) = 'e'
OR
SUBSTRING(CITY, LEN(CITY), 1) = 'i'
OR
SUBSTRING(CITY, LEN(CITY), 1) = 'o'
OR
SUBSTRING(CITY, LEN(CITY), 1) = 'u'