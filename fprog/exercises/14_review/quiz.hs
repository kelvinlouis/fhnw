-- 2
data X = Y Int
a = map Y [2,1]
-- C) [X]

-- 3
-- (head . tail . head . tail) ["abc","abc", ""]
-- B) 'b'

-- 4 
--let a1 = b 
--in f a1
--where b = 12
--      f x | x > 12 = True
--          | otherwise = False
-- A) False

-- 5
-- (\a b -> (a . a) b) (+1) 5
-- D) 7 

-- 6
f 0 (a:_) = a
f n (_:as) = f (n-1) as
-- B) !!

-- 8
data List a = Cons a (List a) | Nil
-- Cons 2 (Const 3 Nil)

-- 9
f1 :: (Num a, Ord a) => a -> a -> a
f1 a b | a == b = a
       | a < b = a + b
-- C

-- 10 
-- foldr (\(a,b) (as, bs) -> (a:as, b:bs)) ([],[]) [(1,'a'), (2,'b')]
-- C) ([1,2], "ab")

-- 11 