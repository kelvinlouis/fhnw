-- 2a
data A = B A | C deriving (Show)
a1 = map B [C,B C]
-- [B C, B (B C)] :: [A]

-- 2b
data G = H Int | J G G deriving (Show)
f1 (H i) = i
f1 (J l r) = f1 l + f1 r
a2 = f1 (J (H 3) (J (H 5) (H 1)))
-- 9 :: Int

-- 2c
data D = E | F Int deriving (Show)
data X a = Y a D deriving (Show)
f2 (Y [a,b] c) = Y [b,a] c
a3 = f2 $ Y [F 1, E] E
-- X [D]

-- 2d
data K a = L a | M deriving (Show)
a4 = foldr (\c acc -> L c : acc) [M] "abc"
-- [K char]

-- 2e
data N a = O Bool | P a deriving (Show)
f3 x y = (P x, P y)
a5 = f3 "Hi" False

-- 2f
data Q = R Int | S Bool

instance Eq Q where
  (S a) == (S b) = a == b
  (R i) == (S True) = i > 10
  a == b = False

a6 = R 12 == S (not False)

-- 3
data Account = Account String [Mutation]
data Mutation = Deposit Int 
              | Withdraw Int

-- 3a
newAccount :: String -> Account
newAccount nr = Account nr []

-- 3b
deposit :: Int -> Account -> Account
deposit amount (Account name mut) = Account name ((Deposit amount):mut)

-- 3c
balance :: Account -> Int
balance (Account _ mut) = foldl mutate 0 mut

mutate :: Int -> Mutation -> Int
mutate x (Deposit y) = x + y
mutate x (Withdraw y) = x - y

-- 3d
balance' :: Account -> Int
balance' (Account _ mut) = sum $ map toInt mut

toInt :: Mutation -> Int
toInt (Deposit x) = x
toInt (Withdraw x) = -x

-- 3e
instance Show Account where
  show (Account n m) = n ++ " : " ++ (show b)
                     where b = balance (Account n m)