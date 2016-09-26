import Data.Char

inc :: Int -> Int
inc = (+1)

-- utility function with $
ln x = putStrLn $ show x

fs = [(+1), (*3), (/2)]
ns = [1,2,3]

main = do
  -- a
  ln (filter even (map inc [1,2,3,4]))
  ln $ filter even $ map inc [1,2,3,4]

  -- b
  ln $ sum $ filter even [1,2,3]
  ln $ map even $ map inc $ filter (>2) [1,2,3]
  ln $ map toUpper $ filter (not.isSpace) "abc def"

  -- c
  ln $ zipWith ($) fs ns
