import Data.Char

-- 4
-- a
normalize :: String -> [String]
normalize qry = filter' $ words lcase
    where lcase = map toLower qry
          filter' = filter (\w -> length w > 3)

-- b
sqlKeyWords = ["select", "from", "where", "order"]

rateWord :: String -> Int
rateWord k
    | elem k sqlKeyWords == True = 5
    | otherwise  = -2

-- c
rateWords :: [String] -> Int
rateWords ws = sum $ map rateWord ws

-- d
isSQL :: String -> Bool
isSQL qry
    | rating > 0 = True
    | otherwise = False
    where rating = (rateWords.normalize) qry


-- 5
type Messwert = (Int, Double) -- (Woche, Pegel)
pegelDB :: [Messwert]
pegelDB = [(1, 4.6), (2, 5.6), (4, 5.9), (5, 6.0), (6, 4.6)]

type PegelDiff = ((Int, Int), Double) -- ((Start Woche, End Woche), Pegel Differenz)

-- a
pegelDiffs :: [Messwert] -> [PegelDiff]
pegelDiffs [] = []
pegelDiffs [_] = []
pegelDiffs (a:b:bs) = (weeks, diff) : pegelDiffs (b:bs)
    where weeks = (fst a, fst b)
          diff = snd b - snd a

-- b
findDiff :: Int -> [PegelDiff] -> [Double]
findDiff _ [] = []
findDiff w (d:ds)
    | inRange == True = snd d : findDiff w ds
    | otherwise = findDiff w ds
    where inRange = w >= start && w < end 
          start = (fst.fst) d
          end = (snd.fst) d