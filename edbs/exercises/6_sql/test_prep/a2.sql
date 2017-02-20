SELECT  f.titel, m.name
FROM    filme f
JOIN    dvdkopien d ON (f.katalognr = d.katalognr)
JOIN    ausleihen a ON (d.dvdnr = a.dvdnr)
JOIN    mitglieder m ON (a.mnr = m.mnr)
WHERE   m.wohnort = 'Bern';

-- 2h
SELECT *
FROM  ausleihen NATURAL JOIN registrierungen;

-- 2h1
SELECT  *
FROM    ausleihen
JOIN    registrierungen USING (mnr, datum);

-- 2h2
SELECT  *
FROM    ausleihen a
JOIN    registrierungen r ON (r.mnr = a.mnr AND r.datum = a.datum);

-- 2h3
SELECT  *
FROM    ausleihen a, registrierungen r
WHERE   a.mnr = r.mnr AND a.datum = r.datum;

-- 3a
SELECT    a.name, r.datum
FROM      angestellte a
LEFT JOIN registrierungen r ON (r.anr = a.anr);

-- 3b
SELECT    datum, name
FROM      angestellte 
RIGHT JOIN registrierungen USING (anr);

-- 3c
SELECT    datum, name
FROM      angestellte 
FULL OUTER JOIN registrierungen USING (anr);

-- 3d
SELECT    m.name, m.wohnort, r.datum as "registriert in F3"
FROM      mitglieder m
LEFT JOIN registrierungen r ON (m.mnr = r.mnr AND r.fnr = 'F3');

-- 3e
SELECT    name, datum
FROM      angestellte
LEFT JOIN registrierungen USING (anr)
WHERE     datum IS NULL;

-- 3f
SELECT  *
FROM    ausleihen NATURAL RIGHT JOIN registrierungen;

-- 4a
SELECT name, wohnort
FROM  mitglieder
ORDER BY wohnort ASC, name DESC;

-- 4b
SELECT mnr, dvdnr, (NVL(rueckgabe, SYSDATE) - datum) as dauer
FROM    ausleihen
ORDER BY dauer DESC, mnr ASC;

-- 4c
SELECT  LOWER(SUBSTR(name,0,2)) as kuerzel
FROM    angestellte
ORDER BY kuerzel ASC;

SELECT  LOWER(SUBSTR(name,0,2))
FROM    angestellte
ORDER BY LOWER(SUBSTR(name,0,2)) ASC;

SELECT  LOWER(SUBSTR(name,0,2))
FROM    angestellte
ORDER BY 1 ASC;

-- 4d
SELECT    m.name, m.wohnort, r.datum as "registriert in F3"
FROM      mitglieder m
LEFT JOIN registrierungen r ON (m.mnr = r.mnr AND r.fnr = 'F3')
ORDER BY r.datum DESC;