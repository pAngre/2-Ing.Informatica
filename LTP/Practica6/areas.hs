module Areas where
    import qualified Circle
    import qualified Triangle

    main = do 
    putStrLn ("El area de un circulo con radio 2 es " ++ show (Circle.area 2))
    let other = (Triangle.area 4 5)
    putStrLn("El area de un triangulo de base 4 y altura 5 es " ++ show other)