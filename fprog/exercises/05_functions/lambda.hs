-- 1a
incAll :: [Int] -> [Int]
incAll = map (\a -> a + 1)
--using section: incAll = map (+1)
--incAll = \x -> map (\a -> a + 1) x 
--incAll x = map (\a -> a + 1) x 

-- 1b
addToAll :: Int -> [Int] -> [Int]
addToAll x = map (\z -> z + x)
--addToAll x = \y -> map (\z -> z + x) y
--addToAll x y = map (\z -> z + x) y

-- 1c
keepOld :: [Int] -> [Int]
keepOld = filter (\y -> y >= 90)
--keepOld = \x -> filter (\y -> y >= 90) x

-- 1d
dropShort :: [String] -> [String]
dropShort = filter (\s -> length s > 1 )
--dropShort = \l -> filter (\s -> length s > 1 ) l

-- 2a) (\x -> > 9) 6 :: Bool
-- 2b) (\x -> tail x) :: [a] -> [a]
-- 2c) (\(a,b) -> b ++ a ) :: ([a],[a]) -> a
-- 2d) (\t -> fst) :: t -> (a,b) -> a