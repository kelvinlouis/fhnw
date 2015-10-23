{-# OPTIONS_GHC -Wall #-}

-- 1
max' :: (Ord a) => a -> a -> a
max' x y  | x >= y = x
          | otherwise = y

-- 1a
maxl :: (Ord a) => [a] -> a
maxl [x] = x
maxl x = max' (head x) (maxl (tail x))

-- or...
maxl' :: (Ord a) => [a] -> a
maxl' x | length x > 1 = max' (head x) (maxl (tail x))
        | otherwise = x!!1

{- 1b
  maxl [2,5,1] = 
  max' (head [2,5,1]) (maxl (tail [2,5,1]))
  max' 2 (max' (head [5,1]) (maxl (tail [5,1])))
  max' 2 (max' 5 (max' (head [1]) (maxl (tail [1]))))
  max' 2 (max' 5 (max' 1 1))
  max' 2 (max' 5 1)
  max' 2 5
  5
-}

-- 2a
reverse' :: [a] -> [a]
reverse' [] = []
reverse' (x:xs) = reverse' xs ++ [x]

{- 2b
  reverse' [1,2,3] = 
  reverse' [2,3] ++ [1]
  (reverse' [3] ++ [2]) ++ [1]
  ((reverse' [] ++ [3]) ++ [2]) ++ [1]
  (([] ++ [3]) ++ [2]) ++ [1]
  ([3] ++ [2]) ++ [1]
  [3,2] ++ [1]
  [3,2,1]
-}

-- 3
alternate :: [a] -> [a] -> [a]
alternate [] y = y
alternate x [] = x 
alternate (x:xs) (y:ys) = x: y: alternate xs ys

{- 
  4.  Implementieren Sie einen Binäraddierer. Die Funktion nimmt zwei gleich grosse Listen und
      ein Carry-In als Parameter. Die Listen sind nur mit 0 oder 1 jeweils gefüllt.
      Im Endresultat darf das Carry-Out an vorderster Stelle der Liste sein.
-}
binAdd :: Int -> [Int] -> [Int] -> [Int]
binAdd c [a] [] = binAdd c [a] [0]
binAdd c [] [b] = binAdd c [0] [b]
binAdd 1 [] [] = [1]
binAdd _ [] [] = []
binAdd c a b
    | sum' == 3 = (binAdd 1 (init a) (init b)) ++ [1]
    | sum' == 2 = (binAdd 1 (init a) (init b)) ++ [0]
    | sum' == 1 = (binAdd 0 (init a) (init b)) ++ [1]
    | otherwise = (binAdd 0 (init a) (init b)) ++ [0]
    where sum' = last a + (last b) + c