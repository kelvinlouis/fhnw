--import Test.HUnit

-- 1  Recursion
-- do later

{- 2  Types
  
  2a
  filter (\x -> True)           :: [a] -> [a]

  2b
  map (\a -> 1) []              :: [Int]

  2c
  (\a -> \b -> (a,b,b)) 1       :: a -> (Int,a,a)
  
  2d
  (\(x,y) -> \(x,z) -> (x,z+y)) :: (a,b) -> (a1,b) -> (a1,b)

  2e
  (\f -> f 2 == "WOW")          :: (Int -> [Char]) -> Bool
-}