-- 1a
safeHead :: [a] -> Maybe a
safeHead [] = Nothing
safeHead (x:xs) = Just x

-- 1b
safeTail :: [a] -> Maybe [a]
safeTail [] = Nothing
safeTail (x:xs) = Just xs

-- 1c
safeMax :: (Ord a) => [a] -> Maybe a
safeMax [] = Nothing
safeMax [x] = Just x
safeMax (x:xs)
    | x > other = Just x
    | otherwise = Just other
    where (Just other) = safeMax xs
