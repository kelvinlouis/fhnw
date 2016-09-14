-- 2a1
SELECT fil.ort, fil.plz, dvd.katalognr, film.titel
FROM filialen fil, dvdkopien dvd, filme film;

-- 2a2
SELECT fil.ort, fil.plz, dvd.katalognr, film.titel
FROM filialen fil
CROSS JOIN dvdkopien dvd
CROSS JOIN filme film;

-- 2b1
SELECT ang.name, reg.datum
FROM angestellte ang
JOIN registrierungen reg USING (anr)
JOIN mitglieder mit USING (mnr);

-- 2b2
SELECT ang.name, reg.datum
FROM angestellte ang
JOIN registrierungen reg ON (ang.anr = reg.anr)
JOIN mitglieder mit ON (reg.mnr = mit.mnr);

-- 2b3
SELECT ang.name, reg.datum
FROM angestellte ang
CROSS JOIN registrierungen reg
CROSS JOIN mitglieder mit
WHERE ang.anr = reg.anr AND
      reg.mnr = mit.mnr;
      
-- 2c
INSERT INTO angestellte VALUES ('A06', 'Hans', 4200);
-- nothing changes, because Hans hasn't registered anything yet

-- 2d
INSERT INTO registrierungen VALUES ('M001', 'F4', NULL, TO_DATE('02.02.2014', 'dd.mm.yyyy'));
-- won't show up in 2b, because the necessary ANR doesn't exist...it's left out

-- 2e1
SELECT film.titel, film.mindestalter, dvd.fnr
FROM filme film
JOIN dvdkopien dvd USING (katalognr);

-- 2e2
SELECT film.titel, film.mindestalter, tmp.fnr
FROM filme film, (
                    SELECT count(*), katalognr, fnr 
                    FROM dvdkopien dvd2
                    GROUP BY katalognr, fnr
                    HAVING count(*) = 1
                  ) tmp
WHERE film.katalognr = tmp.katalognr;                  

-- 2f1
SELECT mit.name, mit.wohnort, reg.datum
FROM mitglieder mit
JOIN registrierungen reg ON (
        mit.mnr = reg.mnr AND
        reg.datum < TO_DATE('01.11.2013','dd.mm.yyyy')
)
JOIN filialen fil ON (
        reg.fnr = fil.fnr AND
        fil.ort = 'Basel'
);

-- 2f2
SELECT mit.name, mit.wohnort, reg.datum
FROM mitglieder mit, registrierungen reg, filialen fil
WHERE (
  mit.mnr = reg.mnr AND
  reg.datum < TO_DATE('01.11.2013','dd.mm.yyyy')
) AND (
  reg.fnr = fil.fnr AND
  fil.ort = 'Basel'
);

-- 2g1
SELECT film.titel, mit.name
FROM filme film
JOIN dvdkopien USING (katalognr)
JOIN ausleihen USING (dvdnr)
JOIN mitglieder mit USING (mnr)
WHERE mit.wohnort = 'Bern';

-- 2g2
SELECT film.titel, mit.name
FROM filme film, dvdkopien dvd, ausleihen aus, mitglieder mit
WHERE film.katalognr = dvd.katalognr AND
      dvd.dvdnr = aus.dvdnr AND
      mit.mnr = aus.mnr AND mit.wohnort = 'Bern';
      
-- 2h
-- SELECT * FROM ausleihen NATURAL JOIN registrierungen
-- doesn't show any records because it is joining the tables using the datum col

-- 2h1
SELECT *
FROM ausleihen aus, registrierungen reg
WHERE aus.datum = reg.datum;

-- 2h2
SELECT *
FROM ausleihen aus
JOIN registrierungen reg ON (aus.datum = reg.datum);

-- 2h3
SELECT *
FROM ausleihen aus
CROSS JOIN registrierungen reg
WHERE aus.datum = reg.datum;

SELECT m.mnr, name, r.fnr
FROM mitglieder m 
LEFT OUTER JOIN registrierungen r ON (m.mnr = r.mnr AND r.fnr = 'F3')
WHERE r.fnr IS NULL;

SELECT * 
FROM filme f LEFT OUTER JOIN dvdkopien d ON (f.katalognr = d.katalognr AND d.FNR = 'F2')
WHERE d.DVDNR IS NULL;


-- 3a
SELECT a.name, r.datum
FROM angestellte a
NATURAL LEFT OUTER JOIN registrierungen r;

-- 3b
SELECT r.datum, a.name
FROM angestellte a
NATURAL RIGHT OUTER JOIN registrierungen r;

-- 3c
SELECT r.datum, a.name
FROM angestellte a
NATURAL FULL OUTER JOIN registrierungen r;

-- 3d
SELECT m.name, m.wohnort, r.datum as "registriert in F3"
FROM mitglieder m
LEFT OUTER JOIN registrierungen r ON (m.mnr = r.mnr AND r.fnr = 'F3');

-- 3e
SELECT a.name, r.datum
FROM angestellte a
NATURAL LEFT OUTER JOIN registrierungen r
WHERE r.datum IS NULL;

-- 3f
-- SELECT *
-- FROM ausleihen NATURAL FULL JOIN registrierungen;

-- FULL: 
