-- 1.a
safeHead :: [a] -> Maybe a
safeHead [] = Nothing
safeHead (x:_) = Just x

-- 1.b
safeTail :: [a] -> Maybe [a]
safeTail [] = Nothing
safeTail (_:xs) = Just xs

-- 1.c
safeMax :: (Ord a) => [a] -> Maybe a
safeMax [] = Nothing
safeMax xs =