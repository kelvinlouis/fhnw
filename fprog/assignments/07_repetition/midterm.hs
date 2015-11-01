import Data.Char

-- 4

-- a
lowerWord :: String -> String
lowerWord = map toLower

-- b
firstUpper :: String -> String
firstUpper (x:xs) = toUpper x : xs

-- c
normalize :: [String] -> [String]
normalize ws = map lowerWord $ filter' ws
    where filter' = filter (\x -> x /= "")

-- d
camelCase :: [String] -> String
camelCase (w:ws) = first ++ (concat $ map firstUpper $ normalize ws)
    where first = lowerWord w

-- 5
type Student = (String, Int)

studentsDB :: [Student]
studentsDB = [("klou@fhnw", 12345), ("udem@fhnw", 67890)]

type GradeEntry = (Int, String, Float)

gradesDB :: [GradeEntry]
gradesDB = [(12345, "fprog", 5.6), (12345, "fprog", 5.3), (67890, "fprog", 4.0), (12345, "chp", 5.0)]

-- a
findMatrikelNr :: [Student] -> String -> Int
findMatrikelNr [] _ = -1
findMatrikelNr (x:xs) em
    | fst x == em = snd x
    | otherwise = findMatrikelNr xs em

-- b

-- extend fst and snd for tripples
fst' (a,_,_) = a
snd' (_,b,_) = b

trd :: (a,b,c) -> c
trd (_,_,c) = c

getGrades :: [GradeEntry] -> Int -> String -> [Float]
getGrades [] _ _ = []
getGrades (e:es) nr mo
    | fst' e == nr && snd' e == mo = trd e : getGrades es nr mo
    | otherwise = getGrades es nr mo

-- c
gradeCheck :: String -> String -> Bool
gradeCheck em mo 
    | mat > -1 = length (getGrades gradesDB mat mo) >= 2
    | otherwise = False
    where mat = findMatrikelNr studentsDB em
