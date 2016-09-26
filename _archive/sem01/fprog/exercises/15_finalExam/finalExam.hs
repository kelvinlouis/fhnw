import Data.Char

-- 2

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

--- 3
data FS = File String Int 
        | Folder String [FS]

fprog = (Folder "fprog" [(Folder "x" [(File "word.doc" 4), (File "spreadsheet.xls" 6)]),(File "ls.txt" 4)])
fprog2 = (Folder "fprog" [(Folder "x" [(File "spreadsheet.xls" 6),(File "word.doc" 4)]),(File "ls.txt" 4)])

size :: FS -> Int
size (File _ s) = s
size (Folder _ xs) = sum $ map size xs

instance Eq FS where
  (File n _) == (File m _) = n == m
  (File _ _) == (Folder _ _) = False
  (Folder n xs) == (Folder m ys) = n == m && (foldr (\x acc -> if x == False then False else acc) True (zipWith (==) xs ys))