{-# LANGUAGE NoMonomorphismRestriction #-}
import System.Environment (withArgs)
import Diagrams.Prelude
import Diagrams.Backend.SVG.CmdLine

-- Don't forget to add a type signature (:: Diagram B) to your creation
main = withArgs (words "-o 3d.svg -w 400") (defaultMain diag)
  where diag = kelvin 12

atopExample, besideExample, aboveExample :: Diagram B
atopExample   = fc black (square 1) `atop` circle 1
besideExample = fc black (square 1) ||| circle 1
aboveExample  = fc black (square 1) === circle 1

--- SOLUTIONS START HERE
-- 3a
triception :: Double -> Diagram B
triception 1 = eqTriangle 1
triception n = eqTriangle n `atop` (triception (n-1))

-- 3b
bwCircles :: Double -> Diagram B
bwCircles 1 = fc white (circle 1)
bwCircles n = bwCircles (n-1) `atop` fc color (circle n) 
    where color | even (round n) = black
                | otherwise = white 

-- 3c
artsy :: Double -> Diagram B
artsy 1 = fc white (square 1)
artsy n = artsy (n-1) `atop` fc color (square n) # rotateBy (n/6) 
    where color | even (round n) = black
                | otherwise = white 