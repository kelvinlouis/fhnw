-- 3a
SELECT name, wohnort
FROM  mitglieder;

-- 3b
SELECT DISTINCT anr
FROM registrierungen
WHERE ANR IS NOT NULL;

-- 3c
SELECT mnr, dvdnr, (rueckgabe - datum) as dauer
FROM    ausleihen
WHERE   (rueckgabe - datum) IS NOT NULL;

-- 3d
SELECT mnr, dvdnr, (NVL(rueckgabe, SYSDATE) - datum) as dauer
FROM    ausleihen;

-- 3e
SELECT  LOWER(SUBSTR(name,0,2))  
FROM    angestellte;

-- 3f1
SELECT  SUBSTR(TO_CHAR(GDATUM, 'YYYY'),3,2)
FROM    mitglieder;

-- 3f2
SELECT  TO_CHAR(GDATUM, 'YY')
FROM    mitglieder;

-- 3g
SELECT  'SQL IST BIS JETZT EINFACH'
FROM    registrierungen;

-- 3h
SELECT  TRIM('    A AAAAA           ') a, USER, USERENV('LANG'), TO_DATE('20.10.1989', 'dd.mm.yyyy')
FROM    dual;

-- 3j
SELECT  CASE mindestalter
          WHEN 9 THEN 'Neun Yo'
          WHEN 12 THEN 'TWELVE HUNNA'
          WHEN 16 THEN 'SWEEEEEET'
          WHEN 6  THEN '6 BROADS IN ATL'
        END  
FROM    filme;

-- 3k
SELECT  ROWID, ROWNUM, mitglieder.*
FROM    mitglieder;

-- 4a
SELECT  *
FROM    ausleihen
WHERE   TO_CHAR(rueckgabe,'YYYY') = '2013';

-- 4b
SELECT  *
FROM    ausleihen
WHERE   TO_CHAR(rueckgabe, 'YYYY') <> '2007';

-- 4c
SELECT  *
FROM    ausleihen
WHERE   TO_CHAR(rueckgabe, 'YYYY') <> '2007' 
        OR rueckgabe IS NULL;
        
-- 4e
SELECT  rueckgabe
FROM    ausleihen
WHERE   mnr = 'M003';

-- 4f
SELECT  mnr, dvdnr
FROM    ausleihen
WHERE   rueckgabe IS NULL;

-- 4g
SELECT  *
FROM    mitglieder
WHERE   (SYSDATE - gdatum) > 35;

-- 4h
SELECT  *
FROM    angestellte
WHERE   LOWER(name) LIKE '%r%';

-- 4i
SELECT  datum
FROM    ausleihen
WHERE   mnr = 'M002' OR mnr = 'M004';

-- 4j
SELECT  *
FROM    filme
WHERE   mindestalter BETWEEN 7 AND 12;