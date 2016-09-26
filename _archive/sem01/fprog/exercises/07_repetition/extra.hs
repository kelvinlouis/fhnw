--  1a
f01 :: [[a]] -> [a]
f01 ([x, y]) = x ++ y
-- note: single tuple can be ignored

-- 1b
f02 :: Num a => [(a,a)] -> a
f02 [(x, y)] = x * y

-- 1c
f03 :: [a] -> (a,a,a)
f03 (x : [y, z]) = (x, y, z)
-- important: this is just one list, taken apart by pattern matching

-- 1d
f04 :: [[a]] -> (a,a,a)
f04 [x : [y, z]] = (x, y, z)

-- 1e 
f05 :: (a,a,[a]) -> [a]
f05 (x, y, z) = x : y : z

-- 1f
f06 :: (a,[a],[[a]]) -> [[a]]
f06 (x, y, z) = (x : y) : z

-- 1g
f07 :: (a,[a],[a]) -> [a]
f07 (x, [y], z) = x : y : z
-- important: y is only a element of the list

-- 1h
f08 :: (a,a,a) -> [a]
f08 (x, y, z) = x : y : [z]

-- 1i
f09 :: [[[a]]] -> (a, [a], [[[a]]])
f09 ([[x]] : [y] : z) = (x, y, z)

{-
  2. Use functions above
  f01 ["test","test2"]          ~> "testtest2
  f01 [[1,2,3],[4,5]]           ~> [1,2,3,4,5]
  f01 [[1,2],[3,4],[5,6]]       ~> exception: non-exhausitve pattern

  f02 [(1,2)]                   ~> 2
  f02 [(4.5,2)]                 ~> 9.0
  f02 [(4.5,4.5)]               ~> 20.25

  f03 [1,2,3]                   ~> (1,2,3)
  f03 "abc"                     ~> ('a','b','c')
  f03 [[1,1],[2,2],[3,3]]       ~> ([1,1],[2,2],[3,3])
  f03 "ab"                      ~> exception: non-exhaustive
  f03 [1,2,3,4]                 ~> exception: non-exhaustive pattern

  f04 [[1,2,3]]                 ~> (1,2,3)
  f04 ["abc"]                   ~> ('a','b','c')
  f04 [[1,2,3,4]]               ~> exception: non-exhaustive pattern

  f05 (1,2,[])                  ~> [1,2]
  f05 (1,2,[3])                 ~> [1,2,3]
  f05 ([1],[2],[[3]])           ~> [[1],[2],[3]]
  f05 ('a', 'b', "c")           ~> "abc"
  f05 (1,[])                    ~> error: no matched type

  f06 (1,[2],[[3]])             ~> [[1,2],[3]]
  f06 ('a',"b",[])              ~> ["ab"]
  f06 ('a',"b",["cd"])          ~> ["ab","cd"]
  f06 ('a',[],[])               ~> ["a"]

  f07 (1,[2],[3])               ~> [1,2,3]
  f07 ('a',"b","")              ~> "ab"
  f07 ('a',"b",[])              ~> "ab"
  f07 ("a",["b"],["c"])         ~> ["a","b","c"]

  f08 (1,2,3)                   ~> [1,2,3]
  f08 ('a','b','c')             ~> "abc"
  f08 ([],[],[1])               ~> [[],[],[1]]

  f09 [[[1]],[[2]],[[3]],[[4]]] ~> (1,[2],[[[3]],[[4]]])
-}
