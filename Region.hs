module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR) --delayR, availableCapacityForR)
   where

import City
import Link
import Tunel
import Quality

data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Reg [] [] [] 

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg citylist linklist tunelist) city = (Reg (citylist ++ [city]) linklist tunelist)

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg citylist linklist tunelist) city1 city2 quality = Reg citylist (linklist ++ [(newL city1 city2 quality)]) tunelist

checkcityR :: Region -> City -> Bool -- chequea si una ciudad pertenece a una region
checkcityR (Reg citylist _ _) citytarget = foldr (\each fold -> each == citytarget || fold ) False citylist

multicheckcityR :: Region -> [ City ] -> Bool -- cheque si todas las ciudades de la lista pertenecen a la region
multicheckcityR (Reg rcitylist rlinklist rtunelist) citylist = foldr(\each fold -> checkcityR (Reg rcitylist rlinklist rtunelist) each || fold ) False citylist

checklinkR :: Region -> [ City ] -> Bool
checklinkR (Reg rcitylist rlinklist rtunelist) citylist = foldr (\(each, next) fold -> linkedR (Reg rcitylist rlinklist rtunelist) each next || fold ) False (zip citylist (tail citylist))

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg rcitylist rlinklist rtunelist) citylist | multicheckcityR (Reg rcitylist rlinklist rtunelist) citylist == False = error "Alguna ciudad no pertenece a la region"

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg _ _ tunelist) city1 city2 = foldr (\each fold -> connectsT city1 city2 each  || fold ) False tunelist


linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg _ linklist _) city1 city2 = foldr (\each fold -> linksL city1 city2 each  || fold ) False linklist

--delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora

--availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades