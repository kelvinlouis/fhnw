--- Aufgabe 2

data A = B Int | C Int String
data D = E D   | F deriving (Show)
data G a = H a | I Int

-- [Int] -> [A]
-- map B

-- G D
-- H (E F)

-- D
-- E (E (E F))

-- D
-- foldr (\e a -> E a) F [B 1]

--- Aufgabe 3
-- a)
data X = Y Int deriving (Show)
a1 = map Y [2,1]
-- a = [(Y 2), (Y 1)]

-- b)
data J = K Int | L String | M deriving (Show)
f (K i) = i
f _ = 0
a2 = map f [K 1, L "AB", M]
-- a2 = [1,0,0]

-- c)
data N = P Int | Q N deriving (Show)
a3 = (Q . P) 1
-- a3 = (Q (P 1))

-- d)
data List a = Elem a (List a) | End deriving (Show)
m g End = End
m g (Elem x xs) = Elem (g x) (m g xs)
a4 = m (+1) (Elem 1 (Elem 2 End))
-- a4 = (Elem 2 (Elem 3 End))

-- 4c
main :: IO()
main = do 
  putStrLn "Hi, I'm Summy"
  summy 0

summy :: Int -> IO()
summy s = do
  putStrLn $ "Current sum = " ++ show s
  num <- getLine
  let sumX = s + (read num :: Int)
  summy sumX


-- 5
-- a
data HTML = Text  {  text :: String } |
            Link  {  href :: String,
                     desc :: String } |
            Table { table :: [[HTML]]}

-- b
class ToHTML a where
  toHTML :: a -> String

-- c
instance ToHTML HTML where
  toHTML (Text t) = t
  toHTML (Link url des) = "<a href='" ++ url ++ "'>" ++ des ++ "</a>"
-- e
  toHTML (Table rows) = "<table>" ++ (foldr (\x acc -> wrapTR x ++ acc) "" rows) ++ "</table>"

-- d
wrapTD :: HTML -> String
wrapTD tag = "<td>" ++ toHTML tag ++ "</td>"

wrapTR :: [HTML] -> String
wrapTR tags = "<tr>" ++ (concat $ map wrapTD tags) ++ "</tr>"
-- wrapTR tags = "<tr>" ++ (foldr (\x acc -> (wrapTD x) ++ acc) "" tags) ++ "</tr>"

-- f
solution = (Table [[(Text "Haskell"), (Text "ist cool")],[(Text "Auf der JVM mag ich"), (Link "http://scala-lang.org" "Scala")]])


