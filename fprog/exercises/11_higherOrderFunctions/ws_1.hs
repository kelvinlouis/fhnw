transform :: (a -> b) -> [a] -> [b]
transform _ [] = []
transform f (x:xs) = f x : transform f xs

data Student = Student { email :: String, 
                        grade :: Float }

students :: [Student]
students = [(Student "kelv@whoot.com" 2), (Student "what@what.com" 3)]

squares :: [Int] -> [Int]
squares = transform (^2)

emails :: [Student] -> [String]
emails = transform email