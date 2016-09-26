aggregate :: (a -> a -> a) -> a -> [a] -> a
aggregate _ x [] = x 
aggregate f d (x:xs) = f x (aggregate f d xs)

sum' :: [Int] -> Int
sum' = aggregate (+) 0

product' :: [Int] -> Int
product' = aggregate (*) 1

or' :: [Bool] -> Bool
or' =  aggregate (||) True

and' :: [Bool] -> Bool
and' = aggregate (&&) True