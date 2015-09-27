-- 1a
threeEquals :: Int -> Int -> Int -> Bool
threeEquals x y z = x == y && y == z

-- alternative?

-- 1b
fourEquals1 :: Int -> Int -> Int -> Int -> Bool
fourEquals1 a b c d = a == b && b == c && c == d

fourEquals2 :: Int -> Int -> Int -> Int -> Bool
fourEquals2 a b c d = ( threeEquals a b c ) && c == d

-- 1c
averageThree :: Int -> Int -> Int -> Double
averageThree x y z = fromIntegral (sum [x,y,z]) / 3

-- 1d
xor :: Bool -> Bool -> Bool
xor x y = x /= y

-- 2a
data Op = Add | Sub

calc :: Op -> Int -> Int -> Int
calc Add x y = x + y
calc Sub x y = x - y

-- 2b
data Menu = BigMac | CheeseRoyal
data Size = Small | Large
type Order = (Menu,Size)

price :: Order -> Int
price (m, Large) = price (m, Small) + 2 
price (BigMac, Small) = 10
price (CheeseRoyal, Small) = 11

-- 3a
swap :: (a,b) -> (b,a)
swap (x, y) = (y, x)

-- 3b
pair :: a -> b -> (a,b)
pair x y = (x, y)

-- 3c
double :: Num a => a -> a
double x = x * 2

-- 3d
crazy :: (Bool, Char, (Bool, Bool)) -> Bool
crazy (a, '&', (b, True)) = not (a && b)

-- 3e 
-- Note: Higher Order Function
twice :: (a -> a) -> a -> a
twice f x = f (f x)

-- 4a
f1 :: Int -> Int
f1 x = x

-- 4b
f2 :: (Int, Bool) -> Int
f2 (x,b) = x

-- 4c
f3 :: a -> (a,Int)
f3 x = (x, 1)

-- 4d
-- f4 :: a -> b
-- Doesn't work, because Haskell is a purely typed language
-- This definition is too vaguely typed, for just receiving one param.

-- 4e
f5 :: a -> (a -> b) -> b
f5 x y = y x
