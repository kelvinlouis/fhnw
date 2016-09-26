data Student = Student { email :: String
                       , grade :: Float 
                       } deriving Show

students :: [Student]
students = [(Student "kelv@whoot.com" 2), (Student "what@what.com" 3), (Student "whoa@sogu.et" 6)]

keep :: (a -> Bool) -> [a] -> [a]
keep _ [] = []
keep p (x:xs) | p x == True = x : continue
              | otherwise = continue
              where continue = keep p xs

evens :: [Int] -> [Int]
evens = keep even

goodS :: [Student] -> [Student]
goodS = keep (\g -> grade g > 5)
--goodS = keep ((>5).grade) -- not very readable