module Ejercicios where
    import Data.Char

    fact :: Int -> Int
    fact 0 = 1
    fact n = n * fact (n-1)

--1
    numCbetw2 :: Char -> Char -> Int
    --numCbetw2 c1 c2 = if abs((ord c1) - (ord c2)) > 1 then abs((ord c1) - (ord c2)) - 1 else 0
    numCbetw2 c1 c2
        |abs((ord c1) - (ord c2)) > 1 = abs((ord c1) - (ord c2)) - 1
        |otherwise = 0
--2    
    addRange :: Int -> Int -> Int
    --addRange x1 x2 = if x1 < x2 then x1 + addRange (x1+1) x2 else if x1 > x2 then x1 + addRange (x1-1) x2 else x1
    addRange x1 x2
        |x1 < x2 = x1 + addRange (x1+1) x2
        |x1 > x2 = x1 + addRange (x1+1) x2
        |x1 == x2 = x1
--3    
    max' :: Int -> Int -> Int
    --max' x1 x2 = if x1 < x2 then x2 else x1
    max' x1 x2
        |x1 < x2 = x2
        |x1 > x2 = x1
        |x1 == x2 = 0
--4    
    leapyear :: Int -> Bool
    --leapyear x = if (mod x 400) == 0 then True else if (mod x 100) == 0 then False else if (mod x 4) ==  0 then True else False
    leapyear x
        |(mod x 400) == 0 = True
        |(mod x 100) == 0 = False
        |(mod x 4) == 0 = True 
        |otherwise = False
--5    
    daysAmonth :: Int -> Int -> Int
    --daysAmonth m y = if m == 2 then if leapyear y then 29 else 28 else if m == 4 || m == 6 || m == 9 || m == 11 then 30 else 31
    daysAmonth m y 
        |m == 2 && leapyear y = 29
        |m == 2 = 28
        |(m == 4 || m == 6 || m == 9 || m == 11) = 30
        |otherwise = 31
--6    
    remainder :: Int -> Int -> Int
    --remainder x y = if x == y then 0 else if x < y then x else remainder (x-y) y
    remainder x y
        |x == y = 0
        |x < y = x
        |x > y = remainder (x-y) y
--7
    sumFacts :: Int -> Int
    sumFacts 1 = fact 1
    sumFacts n = fact n + sumFacts (n-1)
