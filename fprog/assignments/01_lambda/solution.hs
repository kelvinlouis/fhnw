-- 1a. render (lambda `beside` ( lambda `beside` lambda ))

-- 1b. render ((lambda `beside` (invert lambda)) `above` (invert lambda `beside` lambda ) )

-- 1c. render (invert (flipV (flipH lambda)))

-- 2.
-- rotate180 :: Picture -> Picture
-- rotate180 img = flipV ( flipH img )
-- call: render (rotate180 lambda)

-- 3a. square (times2 3)
-- ~> square (2 * 3)    -- using t2
-- ~> square 6          -- arithmetic
-- ~> 6 * 6             -- using sqr
-- ~> 36                -- arithmetic

-- 3b. pyth 2 2
-- ~> square 2 + square 2   -- using py
-- ~> (2 * 2) + square 2    -- using sqr
-- ~> 4 + square 2          -- arithmetic
-- ~> 4 + (2 * 2)           -- using sqr
-- ~> 4 + 4                 -- arithmetic
-- ~> 8                     -- arithmetic

-- 3c. pyth (square 2) 3
-- ~> pyth (2 * 2) 3        -- using sqr
-- ~> pyth 4 3              -- arithmetic
-- ~> square 4 + square 3   -- using pyth
-- ~> (4 * 4) + square 3    -- using sqr
-- ~> 16 + square 3         -- arithmetic
-- ~> 16 + (3 * 3)          -- using sqr
-- ~> 16 + 9                -- arithmetic
-- ~> 25                    -- arithmetic
