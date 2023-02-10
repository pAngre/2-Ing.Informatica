module Shapev2 where
   type Side    = Float
   type Apothem = Float
   type Radius  = Float
   type Height = Float
   type Volume = Float
   type Surface = Float

   data Pentagon = Pentagon Side Apothem
   data Circle   = Circle Radius

   class (Eq a, Show a) => Shape a where
      perimeter :: a -> Float 
      area :: a -> Float

      volumePrism :: a -> Height -> Volume
      surfacePrism :: a -> Height -> Surface

   instance Shape Pentagon where
      perimeter (Pentagon s a) = 5 * s
      area (Pentagon s a) = (5 * s * a) / 2
      volumePrims (Pentagon s a) height = (area Pentagon s a) * height
      surfacePrism (Pentagon s a) height = (perimeter Pentagon s a) * height + 2 * (area Pentagon s a)

   instance Eq Pentagon where
      (==) (Pentagon s1 a1) (Pentagon s2 a2) = (s1 == s2) && (a1 == a2)

   instance Show Pentagon where
      show (Pentagon s a) = "Pentagon " ++ (show s) ++ " " ++ (show a)

   instance Shape Circle where
      perimeter (Circle r) = 2 * pi * r
      area (Circle r) = pi * r * r
      volumePrims (Circle) height = (area Circle r) * height
      surfacePrism (Circle) height = (perimeter Circle r) * height + 2 * (area Circle r)

   instance Eq Circle where
      (==) (Circle r1) (Circle r2) = (r1 == r2)

   instance Show Circle where
      show (Circle r) = "Circle " ++ (show r)

