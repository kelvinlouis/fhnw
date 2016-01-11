import Data.Char

-- WRONG ANSWER :(
cleanString1 :: String -> String
cleanString1 [] = []
cleanString1 (x:xs) | x == ' ' =  cleanString1 xs
                    | otherwise = ((toLower x):cleanString1 xs)

-- Correct!
cleanString2 :: String -> String
cleanString2 [] = []
cleanString2 (' ':xs) = cleanString2 xs
cleanString2 (x:xs) = (toLower x):(cleanString2 xs)

-- map and filter
cleanString3 xs = map toLower $ filter (\x -> not $ x == ' ') xs

-- foldr
cleanString4 xs = foldr con "" xs
                where con l acc = if isNotSpace l then ((toLower l):acc) else acc
                      isNotSpace c = not $ c == ' '