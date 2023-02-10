module QueueFunc where
    import Queue

    toList :: Queue a -> [a]
    toList c
        |size c == 0 = []
        |otherwise = toList (dequeue c) ++  [first c]

    fromList :: [a] -> Queue a
    fromList [] = empty
    fromList (x:xs) = enqueue x (fromList xs)