-- 1
factorial :: Int -> Int
factorial 0 = 1
factorial x = x * (x-1)

-- It's okay, because the function wasn't defined for negative numbers

-- 2
countDown :: Int -> [Int]
countDown 0 = [0]
countDown x = x: countDown (x-1)

-- 3 
countUp :: Int -> [Int]
countUp 0 = [0]
countUp x = countUp(x-1) ++ [x]

-- 4
countDownUp :: Int -> [Int]
countDownUp 0 = [0]
countDownUp x = x: countDownUp(x-1) ++ [x]

countDownUp' :: Int -> [Int]
countDownUp' 0 = [0]
countDownUp' x = pre x ++ post x
            where pre 0 = [0]
                  pre y = y: pre (y-1)
                  post 1 = [1]
                  post y = post (y-1) ++ [y]

-- recursion worksheet 2
-- 1
len :: [a] -> Int
len [] = 0
len (x:xs) = 1 + len xs

-- 2
allTrue :: [Bool] -> Bool
allTrue [] = True
allTrue (x:xs) = x && allTrue xs

-- 3
sublist :: Int -> Int -> [a] -> [a]
sublist s e list  | s < e = list!!s: (sublist (s+1) e list)
                  | s == e = [list!!e]

-- 4
(+++) :: [a] -> [a] -> [a]
(+++) xs [] = xs
(+++) [] ys = ys
(+++) (x:xs) ys = x: xs +++ init(ys) ++ [last ys]