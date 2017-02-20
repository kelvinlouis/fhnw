-- 2a1
SELECT AVG((sysdate - gdatum) / 365) as age
FROM  mitglieder;

-- 2a2
SELECT  AVG(EXTRACT(YEAR from sysdate)- EXTRACT(YEAR from gdatum)) as age
FROM    mitglieder;

-- 2a3
SELECT AVG(EXTRACT(YEAR FROM (sysdate-gdatum) YEAR TO MONTH))
FROM mitglieder;

-- 2a4
SELECT AVG(EXTRACT(YEAR FROM (SELECT sysdate from dual))-EXTRACT(YEAR FROM gdatum))
FROM mitglieder;

-- 2b
SELECT  SUM(rueckgabe - datum) as ausleihtage
FROM    mitglieder
JOIN    ausleihen USING(mnr)
WHERE   name = 'S. Baumann';

-- 2c
SELECT  SUM(gebuehr) as ausleihegebuehren
FROM    mitglieder
JOIN    ausleihen USING(mnr)
JOIN    dvdkopien USING(dvdnr)
JOIN    filme USING(katalognr)
WHERE   name = 'S. Baumann';

-- 2d
SELECT  AVG(COUNT(*))
FROM    registrierungen
GROUP BY  mnr;

SELECT  AVG(COUNT(*))
FROM    registrierungen
GROUP BY  mnr;


-- 2e1
SELECT COUNT(*)
  FROM (SELECT wohnort
        FROM  mitglieder
        GROUP BY wohnort
  );
  
SELECT COUNT(distinct wohnort)
FROM    mitglieder;

-- 2f
SELECT  titel, AVG(NVL(rueckgabe,sysdate) - datum) as "ausleihedauer"
FROM    filme
JOIN    dvdkopien USING(katalognr)
JOIN    ausleihen USING(dvdnr)
GROUP BY titel;

-- 2g
SELECT  ort, plz, COUNT(plz)
FROM    filialen
JOIN    registrierungen USING(fnr)
GROUP BY ort, plz;

-- 2h
SELECT  name, AVG(nvl(rueckgabe, sysdate) - datum) as ausleihedauer
FROM    mitglieder
JOIN    ausleihen USING(mnr)
GROUP BY name
HAVING  AVG(nvl(rueckgabe, sysdate) - datum) > 10;

-- 2i
SELECT  fnr, titel, count(katalognr)
FROM    dvdkopien
JOIN    filme USING(katalognr)
GROUP BY fnr, titel
HAVING count(katalognr) > 1;

-- 2j
SELECT  mindestalter, MIN(gebuehr)
FROM    filme
GROUP BY mindestalter;


-- 3a1
SELECT f.ort, f.plz
FROM  filialen f
JOIN  dvdkopien d ON (f.fnr = d.fnr)
WHERE d.katalognr = (
  SELECT f2.katalognr
  FROM filme f2
  WHERE f2.titel = 'Casablanca'
);

SELECT ort, plz
FROM filialen
WHERE fnr IN (
  SELECT fnr
  FROM dvdkopien
  WHERE katalognr IN (
      SELECT katalognr
      FROM filme
      WHERE titel = 'Casablanca'
  )
);

-- 3a2
SELECT  ort, plz
FROM    filialen
JOIN    dvdkopien USING(fnr)
JOIN    filme USING(katalognr)
WHERE   titel = 'Casablanca';

-- 3b
-- b.i must be unique, otherwise it will return more than just one row (PRIMARY KEY)

-- 3c
SELECT  d.fnr, f.titel, f.mindestalter
FROM    filme f
JOIN    dvdkopien d ON (d.katalognr = f.katalognr)
WHERE   d.fnr IN (
                  SELECT f2.fnr
                  FROM filialen f2
                  JOIN registrierungen r ON (r.fnr = f2.fnr)
                  JOIN mitglieder m ON (m.mnr = r.mnr)
                  WHERE m.name = 'S. Baumann'
                );
                
-- 3d1
SELECT  m.name
FROM    mitglieder m
WHERE   m.mnr IN (
                    SELECT a.mnr
                    FROM ausleihen a
                    JOIN dvdkopien d ON (d.dvdnr = a.dvdnr)
                    JOIN filme f ON (d.katalognr = f.katalognr)
                    WHERE f.titel = 'Ocean''s Eleven' AND 
                          (nvl(rueckgabe, sysdate) - datum) > 10
                 );
                 
-- 3d2
SELECT  m.name
FROM    mitglieder m
JOIN    ausleihen a ON (m.mnr = a.mnr)
JOIN    dvdkopien d ON (a.dvdnr = d.dvdnr)
JOIN    filme f ON (d.katalognr = f.katalognr)
WHERE   f.titel = 'Ocean''s Eleven' AND
        (nvl(a.rueckgabe, sysdate) - a.datum) > 10;
        
-- 3e1
SELECT  f.ort, f.plz
FROM    filialen f
WHERE   3 > (
              SELECT  count(*)
              FROM    registrierungen r
              WHERE   r.fnr = f.fnr
            );        

-- 3e2
SELECT    f.ort, f.plz
FROM      filialen f
JOIN      registrierungen r ON (f.fnr = r.fnr)
GROUP BY f.ort, f.plz
HAVING    count(*) < 3;

-- 3f
SELECT  f.titel, MAX(NVL(a.rueckgabe, sysdate) - a.datum) as ausleihedaduer, m.name 
FROM    filme f
JOIN    dvdkopien d ON (f.katalognr = d.katalognr)
JOIN    ausleihen a ON (d.dvdnr = a.dvdnr)
JOIN    mitglieder m ON (a.mnr = m.mnr)
GROUP BY f.titel, m.name
HAVING (f.titel, MAX(NVL(a.rueckgabe, sysdate) - a.datum)) = (
  SELECT  f2.titel, MAX(NVL(a2.rueckgabe, sysdate) - a2.datum) 
    FROM    filme f2
    JOIN    dvdkopien d2 ON (f2.katalognr = d2.katalognr)
    JOIN    ausleihen a2 ON (d2.dvdnr = a2.dvdnr)
    JOIN    mitglieder m2 ON (a2.mnr = m2.mnr)
    WHERE   f.titel = f2.titel
    GROUP BY f2.titel
);
    
-- 3g1
SELECT      a.name
FROM        angestellte a
LEFT JOIN   registrierungen r ON (r.anr = a.anr)
WHERE       r.anr IS NULL;

-- 3g2
SELECT  name
FROM    angestellte
WHERE   anr NOT IN (
  SELECT anr
  FROM registrierungen r
  WHERE r.anr = anr
);

-- 3g2
SELECT  a.name
FROM    angestellte a
WHERE   NOT EXISTS (
  SELECT anr
  FROM registrierungen r
  WHERE r.anr = a.anr
);

-- 3h2
SELECT  name, count(*)
FROM    registrierungen
JOIN    mitglieder USING (mnr)
GROUP BY name
HAVING count(*) = (
  SELECT  MAX(count(*))
  FROM    registrierungen
  GROUP BY mnr
);

-- 3i
SELECT  f.titel, f.mindestalter, f.gebuehr
FROM    filme f
GROUP BY f.titel, f.mindestalter, f.gebuehr
HAVING (f.mindestalter, MIN(f.gebuehr)) = (
  SELECT  f2.mindestalter, MIN(f2.gebuehr)
  FROM    filme f2
  WHERE   f2.mindestalter = f.mindestalter
  GROUP BY f2.mindestalter
);

--3j1
SELECT  m.name, m.wohnort
FROM mitglieder m
WHERE (
  SELECT count(*)
  FROM  registrierungen
  WHERE mnr = m.mnr
  GROUP BY mnr
) = (SELECT count(*) FROM filialen);

-- 3j2
SELECT  m.name, m.wohnort
FROM    mitglieder m
JOIN    (
          SELECT  mnr, count(*) as cc
          FROM    mitglieder
          GROUP BY mnr
        ) co ON (co.mnr = m.mnr) 
WHERE co.cc = (SELECT count(*) FROM filialen);        