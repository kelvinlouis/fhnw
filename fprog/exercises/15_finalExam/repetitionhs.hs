rep :: Int -> [Int] -> [Int]
rep n = concat . map dup
      where dup x | x == n = [x,x]
                  | otherwise = [x]

reverse' [] = []
reverse' (x:xs) = reverse' xs ++ [x]

alternate :: [a] -> [a] -> [a]
alternate [] b = b
alternate a [] = a
alternate (a:as) (b:bs) = [a,b] ++ alternate as bs

countDown :: Int -> [Int]
countDown 0 = [0]
countDown x = x: (countDown (x - 1))

countUp :: Int -> [Int]
countUp 0 = [0]
countUp x = countUp (x-1) ++ [x]

countDownUp :: Int -> [Int]
countDownUp 0 = [0]
countDownUp n = [n] ++ countDownUp (n-1) ++ [n]

len :: [a] -> Int
len [] = 0
len (x:xs) = 1 + len xs

allTrue :: [Bool] -> Bool
allTrue [] = True
allTrue (x:xs) = x && allTrue xs

(+++) :: [a] -> [a] -> [a]
[] +++ ys = ys
(x:xs) +++ ys = x : (xs +++ ys)


transform :: (a -> b) -> [a] -> [b]
transform _ [] = []
transform f (x:xs) = f x : transform f xs

keep :: (a -> Bool) -> [a] -> [a]
keep _ [] = []
keep p (x:xs) | p x = x : keep p xs
              | otherwise = keep p xs

data Student = Student { grade :: Float }

students = [(Student 5), (Student 6), (Student 7)]

goodS = keep ((>5).grade)

aggregate :: (a -> b -> b) -> [a] -> b -> b
aggregate _ [] acc = acc
aggregate f (x:xs) acc = aggregate f xs (f x acc)

data Tree a = Branch (Tree a) a (Tree a) | Leaf deriving Show

kelvinTree = (Branch (Branch Leaf 6 (Branch Leaf 7 Leaf)) 5 Leaf) 

data Validated a = Ok a | Nok String

notEmpty :: String -> Validated String
notEmpty "" = Nok "It is empty"
notEmpty x = Ok x

safeMax :: (Ord a) => [a] -> Maybe a
safeMax [] = Nothing
safeMax [x] = Just x
safeMax (x:xs) | x > y = Just x
               | otherwise = Just y
               where (Just y) = safeMax xs


