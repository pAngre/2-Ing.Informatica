module Practica5 where

--Parte 1

    divisores :: Int -> [Int]
    divisores x = [i|i<-[1..x],mod x i == 0]

    member :: Int -> [Int] -> Bool
    member x xs = not(null['a'|z<-xs,x==z])

    isPrime :: Int -> Bool
    primes :: Int -> [Int]

    isPrime x = length (divisores x) <= 2

    primos = [x|x<-[1..],length (divisores x) <= 2]
    primes n = take n primos

    selectEven :: [Int] -> [Int]
    selectEven xs = [x|x<-xs, mod x 2 == 0]

    selectEvenPos :: [Int] -> [Int]
    selectEvenPos xs = [x'|(x',p)<-zip xs [0..], mod p 2 == 0]

    iSort :: [Int] -> [Int]
    iSort [] = []
    iSort [x] = [x]
    iSort (x:xs) = ins x (iSort xs)

    ins :: Int -> [Int] -> [Int]
    ins a [] = [a]
    ins a (x:xs)
        |a <= x = (a:x:xs)
        |a > x = (x:ins a xs)

--Parte 2

    doubleAll :: [Int] -> [Int]
    doubleAll xs = map (*2) xs

    map' :: (a -> b) -> [a] -> [b]
    map' f xs = [f x | x <- xs]
    filter' :: (a -> Bool) -> [a] -> [a]
    filter' p xs = [x | x <- xs, p x]

--Parte 3.1

    type Person = String
    type Book = String
    type Database = [(Person,Book)]

    exampleBase :: Database
    exampleBase = [("Alicia","El nombre de la rosa"),("Juan","La hija del canibal"),("Pepe","Odesa"),("Alicia","La ciudad de las bestias")]

    obtain :: Database -> Person -> [Book]
    obtain dBase thisPerson = [book | (person,book) <- dBase, person == thisPerson]

    borrow :: Database -> Book -> Person -> Database
    borrow dBase thisBook thisPerson = dBase ++ [(thisPerson, thisBook)]

    return' :: Database -> (Person,Book) -> Database
    return' dBase (thisPerson,thisBook) = [(p,b)|(p,b)<-dBase,p/=thisPerson && b/=thisBook]

--Parte 3.2

    data Tree a = Leaf a | Branch (Tree a) (Tree a) deriving Show

    symetric :: Tree a -> Tree a
    symetric (Leaf x) = Leaf x
    symetric (Branch x1 x2)  = Branch (symetric x2) (symetric x1)

    listToTree :: [a] -> Tree a
    listToTree (x:xs)
        |null xs = Leaf x
        |otherwise = Branch (Leaf x)(listToTree xs)

    treeToList :: Tree a -> [a]
    treeToList (Leaf x) = [x]
    treeToList (Branch x1 x2) = treeToList x1 ++ treeToList x2

    data BinTreeInt = Void | Node Int BinTreeInt BinTreeInt deriving Show

    insTree :: Int -> BinTreeInt -> BinTreeInt
    insTree x Void = Node x Void Void
    insTree x (Node n b1 b2)
        |x <= n = (Node n (insTree x b1) b2)
        |x > n = (Node n b1 (insTree x b2))

    creaTree :: [Int] -> BinTreeInt
    creaTree [x] = Node x Void Void
    creaTree xs
        |last xs < (last(init xs)) = (Node (last xs) Void (creaTree (init xs)))
        |last xs >= (last(init xs)) = (Node (last xs) (creaTree (init xs)) Void)

    treeElem :: Int -> BinTreeInt -> Bool
    treeElem x Void = False
    treeElem x (Node n Void Void) = x == n
    treeElem x (Node n b1 b2)
        |x < n = treeElem x b1
        |x > n = treeElem x b2
        |x == n = True

    repeated :: Int -> [Int] -> Int
    repeated x xs = length[i | i <- xs, i == x]

    concat' :: [[a]] -> [a]
    concat' [] = []
    concat' (xs:xss) = xs ++ concat' xss


