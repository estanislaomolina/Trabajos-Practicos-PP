module Quality ( Quality, newQ, capacityQ, delayQ )
   where

data Quality = Qua String Int Float deriving (Eq, Show)

newQ :: String -> Int -> Float -> Quality
capacityQ :: Quality -> Int -- cuantos túneles puede tolerar esta conexión
delayQ :: Quality -> Float  -- la demora por unidad de distancia que sucede en las conexiones de este canal