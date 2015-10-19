{-{-# OPTIONS_GHC -Wall #-}-}

{-
  1a)
      Operator                                | Präsedenz
      ---------------------------------------------------
      ((f a) b)                       links     10
      show.(sum [1,2,3])              rechts    9
      2 ^ (2 ^ 3)                     rechts    8
      (2 * 3) * 4                     links     7
      ( 1 / 2 ) / 3                   links     7
      (1 + 2) + 3                     links     6
      (1 - 2) - 3                     links     6
      [1] ++ ([2] ++ [])              rechts    5
      1:(2:(3:[]))                    rechts    5
      (2 == 3) == False               non       4
      (2 /= 3) /= False               non       4
      (2 < 3) < True                  non       4
      (2 > 3) > True                  non       4
      (2 <= 3) <= True                non       4
      (2 >= 3) >= False               non       4
      True && (True && (1<2))         right     3
      True || (True || (1<2))         right     2
                                                1  * look up monand (https://wiki.haskell.org/All_About_Monads)
      sum $ (map (*2) [1,2])          right     0
-}

-- 1b.1
-- 1 + 2 ^ 3 == 6 && 3 / 4 < 12 || snd (1,True)
-- (((1 + (2 ^ 3)) == 6) && ((3 / 4) < 12))) || (snd (1,True))

-- 1b.2
-- (3:) [] == map (*5)[2 ^ 4 ^ 6]
-- ((3:) []) == ((map (*5))[(2 ^ (4 ^ 6))])


-- 2
add :: Int -> Int -> Int
add x y = x + y

add' :: (Int,Int) -> Int
add' (a,b) = a + b

-- 2a
curry' :: ((a,b) -> c) -> a -> b -> c
curry' fn = \x y -> fn (x,y)
-- curry' fn x y = fn (x,y)

addWith1 :: Int -> Int
addWith1 = curry' add' 1

-- 2b
uncurry' :: (a -> b -> c) -> (a,b) -> c
uncurry' fn = \(x,y) -> fn x y
--uncurry' fn (x,y) = fn x y

addWith1' :: Int -> Int
addWith1' = \x -> uncurry' add (x,1)


-- 3
-- 3a
flip' :: (a -> b -> c) -> b -> a -> c

-- 3b
flip' fn x y = fn y x
flip'' fn = \x -> \y -> fn y x


-- 4
f :: Int -> Int
f x = x + 2

g :: Int -> Bool
g x = even x

h :: a -> Int
h _ = 2

i :: Bool -> (Int, Int)
i _ = (1,2)

{- 4a
  f.f :: Int -> Int
  g.f :: Int -> Bool
  h.f :: Int -> Int

  i.g :: Int -> (Int,Int)
  h.g :: Int -> Int

  f.h :: a -> Int
  h.h :: Int -> Int
  g.h :: a -> Bool

  h.i :: Bool -> Int
-}

{- 4b
  (f.fst.i)
  (f.snd.i)
-}