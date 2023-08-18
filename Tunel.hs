module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import City , Link

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT [link] = Tun [link]

connectsT :: City -> City -> Tunel -> Bool -- indica si este tunel conceta estas dos ciudades distintas
connectsT 

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link


delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel