module Tunel ( Tunel, newT, connectsT, usesT, delayT )

   where

import City 
import Link

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun

connectsT :: City -> City -> Tunel -> Bool -- indica si este tunel conceta estas dos ciudades distintas
connectsT ciudad1 ciudad2 (Tun links) | connectsL ciudad1 (head links) && connectsL ciudad2 (last links) || connectsL ciudad2 (head links) && connectsL ciudad1 (last links) = True | otherwise = False

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT linktarget (Tun links) = foldr (\each fold -> each == linktarget || fold ) False links

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links) = foldr (\each fold -> (+) (delayL each) fold) 0 links