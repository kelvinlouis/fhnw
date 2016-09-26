-- 1
-- tail ["a","b"]
-- D) [String]

-- 2
-- filter (\b -> b == True)
-- D) [Bool] -> [Bool]

-- 3
-- fst ([True],[1,2,3])
-- B) [Bool]

-- 4 
-- \(a,b,c) -> \d -> (c,d,a)
-- B) (w,x,y) -> z -> (y,z,w)

-- 5
-- \((a:_),(_:bs)) -> a:bs
-- A) ([a],[a]) -> [a]

-- 6
-- fst.snd
-- (a,(b,c)) -> b

-- 7
-- map (\(a,b) -> a * b) [(1,2),(3,4),(4,5)]
-- A) [2,12,20]

-- 8 
-- "2" ++ "1"
-- C) "21"

-- 9
-- (\(a,b,c) -> (a-b,b-c)) (1,2,3)
-- B) (-2,-1)

-- 10
-- fst [1,2,3]
-- D) Ungueltiger Ausdruck

-- 11
-- (tail.head) ["Hi", "Hallo", "Hej"]
-- C) "i" :: [Char]