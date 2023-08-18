module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where

import City
import Quality

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL cit1 cit2 qua  = Lin cit1 cit2 qua

connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL ciudad (Lin cit1 cit2 _) | ciudad == cit1 = True
                                   | ciudad == cit2 = True
                                   | otherwise = False

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL ciudad1 ciudad2 (Lin cit1 cit2 _) | ((ciudad1 == cit1) && (ciudad2 == cit2)) || ((ciudad1 == cit2)&&(ciudad2 == cit1)) = True
                                         | otherwise = False

capacityL :: Link -> Int
capacityL (Lin _ _ qua) = capacityQ qua

delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL (Lin _ _ qua) = delayQ qua
