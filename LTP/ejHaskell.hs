module EjHaskell where

--Ej1
    primerosSuma :: Int -> [Int] -> [Int]
    primerosSuma n (x:xs)
    	|x >= n = [x]
    	|x < n = x:(primerosSuma (n-x) xs)

--Ex2022
    zipp :: [a] -> [b] -> [c] -> [(a,b,c)]
    zipp x y z = [(x!!i,y!!i,z!!i)|i <- [0..l-1]]
    	where l = min(length x) (min (length y) (length z))

    data Tree a = Void | Branch a (Tree a) (Tree a) deriving Eq

    sizeTree :: Tree a -> Int
    sizeTree Void = 0
    sizeTree (Branch _ x y) = 1 + sizeTree x + sizeTree y

    equilibrado :: Tree a -> Bool
    equilibrado (Branch _ x y) = (sizeTree x - sizeTree y) == 0

    instance (Ord a) => Ord (Tree a) where
    	x < y = sizeTree x < sizeTree y
    	x <= y = sizeTree x <= sizeTree y 

--Ex2021
	mapfilter :: (a -> a) -> (a -> Bool) -> [a] -> [a]
	mapfilter _ _ [] = []
	mapfilter g f x:xs
		|f x = g x : mapfiler g f xs
		|otherwise = x : mapfilter g f xs

	
	data BinTreeInt = Void | Node Int BinTreeInt BinTreeInt deriving (Eq, Show)

	sumMaxPath :: BinTreeInt -> Int 
	sumMaxPath Void = 0
	sumMaxPath Node x _ y = x + sumMaxPath y

	type Title = String
	type Authors = [String]
	type Duration = Float
	type Languages = Int 
	data Obra = Obra Title Authors
	data Audiovisual = Audiovisual Obra Duration Languages
	class Translation where
		translated :: a -> Bool
		translations :: a -> Int 

		translated Audiovisual(_ _ x) = x > 1
		translations Audiovisual(_ _ x) = x  - 1


--Ex2020
	class (Show a, Eq a) => Shape a where
		area :: a -> Float
		perimeter :: a -> Float
		distance :: a -> Float

		areaSum :: (Shape a) => [a] -> Float
		areaSum [] = 0
		areaSum (x:xs) = area x + areaSum xs

		distanceFilter :: (Shape a) => [a] -> Float -> [a]
		distanceFilter [] _ = []
		distanceFilter (x:xs) d
			|distance x > d = x:distanceFilter xs d
			|otherwise = distanceFilter xs d

		ins :: (Shape a) => a -> [a] -> [a]
		ins f [] = [f]
		ins f (x:xs)
			|area f <= area x = f:x:xs 
			|otherwise = x : ins f xs