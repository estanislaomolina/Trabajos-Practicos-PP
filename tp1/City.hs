module City ( City, newC, nameC, distanceC )
   where

import Point

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
newC name point = Cit name point

nameC :: City -> String
nameC (Cit name point) = name

distanceC :: City -> City -> Float -- la distancia entre dos ciudades usando la funcion difP
distanceC (Cit _ point1) (Cit _ point2) = difP point1 point2