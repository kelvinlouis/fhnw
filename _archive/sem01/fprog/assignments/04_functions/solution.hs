-- 1) rewrite the function compare
-- 1a) use if-then-else
compareWithIf :: (Ord a) => a -> a -> Ordering
compareWithIf a b = if a > b
                      then GT
                      else if a < b
                        then LT
                        else EQ

-- 1b) use guards
compareWithGuards :: (Ord a) => a -> a -> Ordering
compareWithGuards a b | a > b = GT
                      | a < b = LT
                      | otherwise = EQ

-- 1c) use cases
compareWithCases :: (Ord a) => a -> a -> Ordering
compareWithCases a b = case a > b of
                        True -> GT
                        otherwise -> case a < b of
                          True -> LT
                          otherwise -> EQ


{-
  1d) It cannot be done using pattern matching, because Haskell doesn't allow expressions
      as patterns.
-}

-- 2a) using pattern matching: what happens if no pattern matches
something :: [a] -> Int
something (a:b:xs) = 3

{-
ghci> something [1]
*** Exception: solution.hs:35:1-22: Non-exhaustive patterns in function something
-}

-- 2b) using pattern matching: what happens if patterns overlap
overlap :: [a] -> Int
-- overlap (a:xs) = 2
-- overlap (a:b:xs) = 3
-- overlap (a:b:c:xs) = 4
overlap (a:b:c:xs) = 4
overlap (a:b:xs) = 3
overlap (a:xs) = 2

{- Compiler warning on reload: the second and third pattern will never be executed.
   One possible fix: move the more explicit patterns up.

  solution.hs:44:1: Warning:
    Pattern match(es) are overlapped
    In an equation for `overlap':
        overlap (a : b : xs) = ...
        overlap (a : b : c : xs) = ...
Ok, modules loaded: Main.
-}

-- 3
type Coord = (Int,Int)
type M22 = (Coord,Coord)

{-
  [ 1 2 ] [ 1 2 ]
  [ 3 4 ] [ 3 4 ]
-}

row :: (Int -> Int -> Int) -> Coord -> Coord -> Coord
row op left right = (fst left `op` fst right, snd left `op` snd right)
rowAdd = row (+)
rowSub = row (-)
rowMul = row (*)

add :: M22 -> M22 -> M22
add (t1, b1) (t2, b2) = (rowAdd t1 t2, rowAdd b1 b2)

sub :: M22 -> M22 -> M22
sub (t1, b1) (t2, b2) = (rowSub t1 t2, rowSub b1 b2)

mulS :: M22 -> Int -> M22
mulS (top, bottom) scalar = (multiply top, multiply bottom)
    where multiply cell = (fst cell * scalar, snd cell * scalar)

mul :: M22 -> M22 -> M22
mul (t1, b1) (t2, b2) = (rowMul t1 t2, rowMul b1 b2)