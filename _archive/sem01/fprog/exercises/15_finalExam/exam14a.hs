-- 4a
data BExpr = C Bool
           | V BExpr BExpr
           | N BExpr deriving (Show)

-- 4c
eval :: BExpr -> Bool
eval (C x) = x
eval (V e f) = eval e || (eval f)
eval (N e) = not $ eval e

-- d
parseBExpr :: String -> BExpr
parseBExpr _ = (V (C True) (C False))


main :: IO ()
main = do
  putStrLn "Enter an expression pr ':quit' to terminate:"
  expr <- getLine
  if expr == ":quit" then
    return ()
  else do
    putStrLn $ "Result: " ++ (show $ (eval . parseBExpr) expr)
    main
